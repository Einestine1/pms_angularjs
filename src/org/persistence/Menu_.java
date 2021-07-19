package org.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.849+0300")
@StaticMetamodel(Menu.class)
public class Menu_ {
	public static volatile SingularAttribute<Menu, Long> id;
	public static volatile SingularAttribute<Menu, String> title;
	public static volatile SingularAttribute<Menu, Boolean> isVisible;
	public static volatile CollectionAttribute<Menu, MenuItem> menuItem;
	public static volatile SingularAttribute<Menu, String> attribute1;
}
