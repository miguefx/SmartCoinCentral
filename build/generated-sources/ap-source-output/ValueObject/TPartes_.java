package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TPartes.class)
public class TPartes_ { 

    public static volatile SingularAttribute<TPartes, Integer> cantidadActual;
    public static volatile SingularAttribute<TPartes, String> nombreParte;
    public static volatile SingularAttribute<TPartes, Boolean> estado;
    public static volatile SingularAttribute<TPartes, Integer> numParte;
    public static volatile SingularAttribute<TPartes, Boolean> sincronizacion;
    public static volatile SingularAttribute<TPartes, String> tipoParte;
    public static volatile SingularAttribute<TPartes, Double> dineroActual;
    public static volatile SingularAttribute<TPartes, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TPartes, Double> cantidadMax;
    public static volatile SingularAttribute<TPartes, Double> denominacion;
    public static volatile SingularAttribute<TPartes, Double> cantidadAlarma;
    public static volatile SingularAttribute<TPartes, Boolean> prioritario;
    public static volatile SingularAttribute<TPartes, String> iPDispositivo;
    public static volatile SingularAttribute<TPartes, TSedes> idSede;
    public static volatile SingularAttribute<TPartes, Double> cantidadMin;
    public static volatile SingularAttribute<TPartes, Long> idParte;

}