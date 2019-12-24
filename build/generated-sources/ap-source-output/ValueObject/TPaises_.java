package ValueObject;

import ValueObject.TCiudades;
import ValueObject.TSedes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TPaises.class)
public class TPaises_ { 

    public static volatile ListAttribute<TPaises, TCiudades> tCiudadesList;
    public static volatile SingularAttribute<TPaises, Long> idpais;
    public static volatile SingularAttribute<TPaises, String> abreviatura;
    public static volatile ListAttribute<TPaises, TSedes> tSedesList;
    public static volatile SingularAttribute<TPaises, String> pais;

}