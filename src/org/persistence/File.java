package org.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
public class File implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = AUTO)
	private long id;
	private String registrationNumber;
	@OneToOne
	private Plot plot;
	@ManyToMany(mappedBy = "file")
	private Collection<Member> member;
	@OneToOne(mappedBy = "file")
	private PlotSize requestedPlotSize;
	@OneToMany
	private Collection<PlotCategory> requestedPlotCategory;
	@OneToMany
	private Collection<FileStatus> fileStatus;
	@Basic
	@Temporal(DATE)
	private Date registrationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String param) {
		this.registrationNumber = param;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot param) {
		this.plot = param;
	}

	public Collection<Member> getMember() {
		return member;
	}

	public void setMember(Collection<Member> param) {
		this.member = param;
	}

	public PlotSize getRequestedPlotSize() {
		return requestedPlotSize;
	}

	public void setRequestedPlotSize(PlotSize param) {
		this.requestedPlotSize = param;
	}

	public Collection<PlotCategory> getRequestedPlotCategory() {
		return requestedPlotCategory;
	}

	public void setRequestedPlotCategory(Collection<PlotCategory> param) {
		this.requestedPlotCategory = param;
	}

	public Collection<FileStatus> getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(Collection<FileStatus> param) {
		this.fileStatus = param;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date param) {
		this.registrationDate = param;
	}

}