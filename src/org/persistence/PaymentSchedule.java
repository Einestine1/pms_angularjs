package org.persistence;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaymentSchedule implements Serializable {

	private static final long serialVersionUID = 1L;

	public PaymentSchedule() {
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	private String name;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

}