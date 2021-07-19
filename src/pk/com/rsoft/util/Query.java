package pk.com.rsoft.util;

import java.util.ArrayList;

import pk.com.rsoft.util.Operator.OPERATOR_TYPE;

public class Query {
	private ArrayList<Operator> ops;
	private ArrayList<Field> fields;
	private Class<?> cls;
	private boolean isWhereCalled = false;

	public <T> Query(Class<T> obj) {
		// TODO Auto-generated constructor stub
		// this.strQuery = strQuery;
		if (obj instanceof Class) {
			this.cls = obj;
		} else {
			this.cls = obj.getClass();
		}
		this.ops = new ArrayList<Operator>();
		this.fields = new ArrayList<Field>();
	}

	public Query and(Field field) throws IllegalOperationException {

		checkIfWhereCalled();// if where is not used then raise an exception and
								// return
		this.addOperator(field, OPERATOR_TYPE.AND);
		return this;
	}

	public Query or(Field field) throws IllegalOperationException {
		checkIfWhereCalled();// if where is not used then raise an exception and
								// return
		this.addOperator(field, OPERATOR_TYPE.OR);
		return this;
	}

	public Query where(Field field) throws IllegalOperationException {
		if (cls == null) {
			throw new IllegalOperationException(
					"Query not initialized, please use Query(Class<T> obj) or setClass(Class<T> obj) method first!");
		}

		this.fields.add(field);
		isWhereCalled = true;
		return this;
	}

	private boolean hasWhereCalled() {
		return isWhereCalled;
	}

	private void checkIfWhereCalled() throws IllegalOperationException {
		if (!hasWhereCalled()) {
			throw new IllegalOperationException(
					"Query is not initilazed, Please use .where before callaing .and()/.or() first!");
		}

	}

	private void addOperator(Field field, OPERATOR_TYPE opType) {
		this.fields.add(field);
		this.ops.add(new Operator(opType));
	}

	public String getJPAQueryString() throws IllegalOperationException {
		return buildJPAQueryString();
	}

	private String buildJPAQueryString() throws IllegalOperationException {
		// TODO Auto-generated method stub
		if(cls==null)
		{
			throw new IllegalOperationException("Required Entity class is not set plese used setClass(Class<T> obj) first!");
		}
		String strRetValue = "select o from " + cls.getSimpleName()+ " o ";
		int index = 0;
		boolean first = true;
		for (Field f : fields) {
			if (first) {
				strRetValue += " where o." + f.toString() ;//f.getName() + "=:" + f.getName();
				first = false;
			} else {
				Operator op = ops.get(index++);
				strRetValue +=" "+op.toString() + " o." +f.toString();// f.getName() + "=:" + f.getName();
			}
		}

		return strRetValue;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
}
