package org.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import static javax.persistence.GenerationType.AUTO;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {
		setUserName("");
		setPassword("");
		setFirstName("");
		setLastName("");
		setEmail("");
		setIsAdmin(false);
		
	}

	@Autowired
	@Id
	@GeneratedValue(strategy = AUTO, generator = "User_Pk_Id")
	@SequenceGenerator(name = "User_Pk_Id")
	private long id;
	private String userName;
	private String password;
	private Boolean isAdmin;
	private String email;
	private String firstName;
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String param) {
		this.userName = param;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String param) {
		this.password = param;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean param) {
		this.isAdmin = param;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String param) {
		this.firstName = param;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String param) {
		this.lastName = param;
	}

}