package pk.com.rsoft.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.persistence.Member;
import org.persistence.User;
@SuppressWarnings("unused")
public class DBManager {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("PMSORM");
		em = emf.createEntityManager() ;
	}

	
	public DBManager() {
		// TODO Auto-generated constructor stub
		
	}

	@SuppressWarnings("unchecked")
	public void printUsersList() {
		// TODO Auto-generated method stub
		List<User> memList = em.createQuery("Select u from Member u").getResultList();
		int i =0;
		for(User u: memList)
		{
			System.out.print(++i+" "+u);
			if(i%20==0)
				{
					System.out.println(" "+i);
				}	
		}
	}

	public <T> List<T> executeQuery(Class<T> typeClass, String query, ArrayList<Field> params)
	{
		
		TypedQuery<T> qlQuery = em.createQuery(query,typeClass);
		for(Field field : params)
		{
			qlQuery.setParameter(field.getName(),field.getValue());
		}
		
		return qlQuery.getResultList();
	}
	private void createUser() {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PMSORM");

		EntityManager em = emf.createEntityManager() ;
		em.getTransaction().begin();
		
		em.getTransaction().commit();
	}
	
	public void createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public  void updateUser(User user){
		em.getTransaction().begin();
		
		User tmpUser = (User) findById(user, "userName", user.getUserName());
		tmpUser.setPassword(user.getPassword());
		em.persist(tmpUser);
		em.getTransaction().commit();		
	}
	
	public <T> Object findById(T obj,String fieldName,Object id) throws NoResultException
	{
		return findById(obj.getClass(), fieldName, id);
	}
	
	public <T> Object findById(Class<T> objClass,String fieldName, Object id) throws NoResultException
	{

		String qry = "Select e from "+objClass.getSimpleName()+" e where e."+fieldName+"= :param1";
		Query query = em.createQuery(qry);

		query.setParameter("param1", id);
		
		return (query.getSingleResult());
	}
	public <T> Object Insert(T obj)
	{
		em.persist(obj);
		return obj;
	}
	
	public <T> Object Update(T obj)
	{
		em.persist(obj);
		return obj;
	}
	
	public <T> void Delete (T obj)
	{
		em.remove(obj);
	}
	
	public Query createQuery(String strQuery)
	{
		return em.createQuery(strQuery);
	}
	
	public <T> ArrayList<T> getAll(T obj)
	{

		return getAll(obj,0,0);
	}
	
	public <T> long getAllCount(T obj)
	{
		return getAll(obj).size();
	}
	
	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> getAll(T obj, int startPage, int pageSize)
	{
	
		String strQry="";
		if(!(obj instanceof Class))
		{
			strQry = "Select e from "+obj.getClass().getSimpleName()+" e";
		}
		else
		{
			strQry = "Select e from "+((Class<?>)obj).getSimpleName()+" e";
		}

		Query query = em.createQuery(strQry);
		
		if(startPage>0 && pageSize>0)//If page size and number of records is greater than zero
		{
			int firstRecordIndex = pageSize * (startPage-1);
		
			query.setFirstResult(firstRecordIndex);
			query.setMaxResults(pageSize);
		}
		
		List<T> retList = query.getResultList();
		return new ArrayList<T>(retList) ;
	}
	
	public EntityManagerFactory getEntityManagerFactory()
	{
		return emf;
	}
	public EntityManager getEntityManager()
	{
		return em;
	}
	
	private <T> String buildQuery(Class<T> obj,ArrayList<Field> params){
		String strRetQuery="";
		if(obj instanceof Class)
		{
			strRetQuery = "select o from "+obj.getSimpleName();
		}
		else 
		{
			strRetQuery = "select o from "+obj.getClass().getSimpleName();
		}
		
		if(!params.isEmpty())
		{
			strRetQuery+=" where ";
		}
		for(Field f:params)
		{
			strRetQuery+="o."+f.getName()+" ";
			
		}
		
		return strRetQuery;
	}
	

}
