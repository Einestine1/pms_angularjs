package org.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

@Entity
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public MenuItem() {
	}

	@Id
	private long id;
	private String title;
	private Boolean isEnabled;
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "Menu_id", referencedColumnName = "id")
	private Menu menu;
	private String targetFrame;
	private String href;

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

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean param) {
		this.isEnabled = param;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu param) {
		this.menu = param;
	}

	public String getTargetFrame() {
		return targetFrame;
	}

	public void setTargetFrame(String param) {
		this.targetFrame = param;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String param) {
		this.href = param;
	}

}