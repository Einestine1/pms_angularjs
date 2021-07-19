package org.persistence;

import static javax.persistence.GenerationType.TABLE;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	public Member() {
	}

	@Id
	@GeneratedValue(strategy = TABLE)
	private long id;
	private String fName;
	private String mName;
	private String lName;
	@ManyToMany
	private Collection<File> file;
	private String membershipNumber;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String param) {
		this.fName = param;
	}

	public String getMName() {
		return mName;
	}

	public void setMName(String param) {
		this.mName = param;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String param) {
		this.lName = param;
	}

	public Collection<File> getFile() {
		return file;
	}

	public void setFile(Collection<File> param) {
		this.file = param;
	}

	public String getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(String param) {
		this.membershipNumber = param;
	}

	@Override
	public String toString()
	{
		if(mName!=null)
		{
			return getFName()+" "+getMName()+" "+getLName();
		}
		else 
		{
			return getFName()+" "+getLName();
		}
		}
	
}