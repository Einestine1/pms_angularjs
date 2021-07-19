package org.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.893+0300")
@StaticMetamodel(Plot.class)
public class Plot_ {
	public static volatile SingularAttribute<Plot, Long> id;
	public static volatile SingularAttribute<Plot, String> plotNumber;
	public static volatile SingularAttribute<Plot, PlotStatus> plotStatus;
	public static volatile SingularAttribute<Plot, PlotSize> plotSize;
	public static volatile SingularAttribute<Plot, PlotCategory> plotCategory;
}
