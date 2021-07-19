package org.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

@Entity
public class PlotSize implements Serializable {

	private static final long serialVersionUID = 1L;

	public PlotSize() {
	}

	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	private String length;
	private String width;
	private String area;
	@OneToOne
	private File file;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String param) {
		this.length = param;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String param) {
		this.width = param;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String param) {
		this.area = param;
	}

	public File getFile() {
	    return file;
	}

	public void setFile(File param) {
	    this.file = param;
	}

}