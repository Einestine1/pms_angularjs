package org.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-19T12:46:10.846+0300")
@StaticMetamodel(Member.class)
public class Member_ {
	public static volatile SingularAttribute<Member, Long> id;
	public static volatile SingularAttribute<Member, String> fName;
	public static volatile SingularAttribute<Member, String> mName;
	public static volatile SingularAttribute<Member, String> lName;
	public static volatile CollectionAttribute<Member, File> file;
	public static volatile SingularAttribute<Member, String> membershipNumber;
}
