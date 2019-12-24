package ValueObject;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:50")
@StaticMetamodel(TPermisos.class)
public class TPermisos_ { 

    public static volatile SingularAttribute<TPermisos, String> nombreControl;
    public static volatile SingularAttribute<TPermisos, Boolean> sincronizacion;
    public static volatile SingularAttribute<TPermisos, Long> idPermiso;
    public static volatile SingularAttribute<TPermisos, Long> documentoUsuario;
    public static volatile SingularAttribute<TPermisos, String> idModulo;
    public static volatile SingularAttribute<TPermisos, BigInteger> idSede;
    public static volatile SingularAttribute<TPermisos, Long> idCiudad;

}