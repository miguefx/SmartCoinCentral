package ValueObject;

import ValueObject.TPaises;
import ValueObject.TSedes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TCiudades.class)
public class TCiudades_ { 

    public static volatile SingularAttribute<TCiudades, TPaises> idpais;
    public static volatile ListAttribute<TCiudades, TSedes> tSedesList;
    public static volatile SingularAttribute<TCiudades, String> ciudad;
    public static volatile SingularAttribute<TCiudades, Long> idciudad;

}