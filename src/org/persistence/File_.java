package org.persistence;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.527+0300")
@StaticMetamodel(File.class)
public class File_ {
	public static volatile SingularAttribute<File, Long> id;
	public static volatile SingularAttribute<File, String> registrationNumber;
	public static volatile SingularAttribute<File, Plot> plot;
	public static volatile CollectionAttribute<File, Member> member;
	public static volatile SingularAttribute<File, PlotSize> requestedPlotSize;
	public static volatile CollectionAttribute<File, PlotCategory> requestedPlotCategory;
	public static volatile CollectionAttribute<File, FileStatus> fileStatus;
	public static volatile SingularAttribute<File, Date> registrationDate;
}
