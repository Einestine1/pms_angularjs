package org.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.925+0300")
@StaticMetamodel(PlotSize.class)
public class PlotSize_ {
	public static volatile SingularAttribute<PlotSize, Long> id;
	public static volatile SingularAttribute<PlotSize, String> length;
	public static volatile SingularAttribute<PlotSize, String> width;
	public static volatile SingularAttribute<PlotSize, String> area;
	public static volatile SingularAttribute<PlotSize, File> file;
}
