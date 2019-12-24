package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TMovimientos;
import ValueObject.TSedes;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TCargas.class)
public class TCargas_ { 

    public static volatile ListAttribute<TCargas, TMovimientos> tMovimientosList;
    public static volatile SingularAttribute<TCargas, Long> idCarga;
    public static volatile SingularAttribute<TCargas, BigInteger> idLocal;
    public static volatile SingularAttribute<TCargas, Date> fechaInicio;
    public static volatile SingularAttribute<TCargas, Boolean> sincronizacion;
    public static volatile SingularAttribute<TCargas, BigInteger> idUsuario;
    public static volatile SingularAttribute<TCargas, Date> fechaUltimaAnterior;
    public static volatile SingularAttribute<TCargas, Double> valor;
    public static volatile SingularAttribute<TCargas, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TCargas, TSedes> idSede;
    public static volatile SingularAttribute<TCargas, Date> fechaFin;

}