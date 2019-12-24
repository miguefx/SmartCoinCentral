package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import ValueObject.TUsuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TEventos.class)
public class TEventos_ { 

    public static volatile SingularAttribute<TEventos, Date> fechaEvento;
    public static volatile SingularAttribute<TEventos, String> evento;
    public static volatile SingularAttribute<TEventos, Boolean> sincronizacion;
    public static volatile SingularAttribute<TEventos, Long> idEvento;
    public static volatile SingularAttribute<TEventos, TUsuarios> idUsuario;
    public static volatile SingularAttribute<TEventos, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TEventos, TSedes> idSede;

}