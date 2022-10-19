package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-17T21:36:08")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile ListAttribute<Country, User> userList;
    public static volatile SingularAttribute<Country, String> nationality;
    public static volatile ListAttribute<Country, User> userList1;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile SingularAttribute<Country, Integer> id;

}