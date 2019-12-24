package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:50")
@StaticMetamodel(TParametros.class)
public class TParametros_ { 

    public static volatile SingularAttribute<TParametros, Long> idParametro;
    public static volatile SingularAttribute<TParametros, String> descripcion;
    public static volatile SingularAttribute<TParametros, String> codigo;
    public static volatile SingularAttribute<TParametros, Boolean> estado;
    public static volatile SingularAttribute<TParametros, Boolean> sincronizacion;
    public static volatile SingularAttribute<TParametros, String> valor;
    public static volatile SingularAttribute<TParametros, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TParametros, TSedes> idSede;

}