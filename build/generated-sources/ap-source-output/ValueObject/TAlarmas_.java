package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TAlarmas.class)
public class TAlarmas_ { 

    public static volatile SingularAttribute<TAlarmas, String> descripcion;
    public static volatile SingularAttribute<TAlarmas, String> usuarioObservacion;
    public static volatile SingularAttribute<TAlarmas, Date> fechaRegistro;
    public static volatile SingularAttribute<TAlarmas, String> tipoError;
    public static volatile SingularAttribute<TAlarmas, Date> fechaSolucion;
    public static volatile SingularAttribute<TAlarmas, String> parte;
    public static volatile SingularAttribute<TAlarmas, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TAlarmas, Integer> nivelError;
    public static volatile SingularAttribute<TAlarmas, Date> fechaAtencion;
    public static volatile SingularAttribute<TAlarmas, TSedes> idSede;
    public static volatile SingularAttribute<TAlarmas, Long> idAlarma;
    public static volatile SingularAttribute<TAlarmas, String> observacion;

}