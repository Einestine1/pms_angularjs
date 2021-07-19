package org.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	public Menu() {
	}

	@Id
	private long id;
	private String title;
	private Boolean isVisible;
	@OneToMany(mappedBy = "menu")
	private Collection<MenuItem> menuItem;
	private String attribute1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String param) {
		this.title = param;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean param) {
		this.isVisible = param;
	}

	public Collection<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Collection<MenuItem> param) {
		this.menuItem = param;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setIsEnabled(String param) {
		this.attribute1 = param;
	}

}