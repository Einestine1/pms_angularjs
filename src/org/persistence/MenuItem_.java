package org.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.862+0300")
@StaticMetamodel(MenuItem.class)
public class MenuItem_ {
	public static volatile SingularAttribute<MenuItem, Long> id;
	public static volatile SingularAttribute<MenuItem, String> title;
	public static volatile SingularAttribute<MenuItem, Boolean> isEnabled;
	public static volatile SingularAttribute<MenuItem, Menu> menu;
	public static volatile SingularAttribute<MenuItem, String> targetFrame;
	public static volatile SingularAttribute<MenuItem, String> href;
}
