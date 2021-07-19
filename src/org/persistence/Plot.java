package org.persistence;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Plot implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	private String plotNumber;
	@ManyToOne
	private PlotStatus plotStatus;
	@ManyToOne
	private PlotSize plotSize;
	@ManyToOne
	private PlotCategory plotCategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String param) {
		this.plotNumber = param;
	}

	public PlotStatus getPlotStatus() {
		return plotStatus;
	}

	public void setPlotStatus(PlotStatus param) {
		this.plotStatus = param;
	}

	public PlotSize getPlotSize() {
		return plotSize;
	}

	public void setPlotSize(PlotSize param) {
		this.plotSize = param;
	}

	public PlotCategory getPlotCategory() {
		return plotCategory;
	}

	public void setPlotCategory(PlotCategory param) {
		this.plotCategory = param;
	}

}