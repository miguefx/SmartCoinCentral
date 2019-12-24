package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:50")
@StaticMetamodel(TFacturacion.class)
public class TFacturacion_ { 

    public static volatile SingularAttribute<TFacturacion, String> fechaFinResolucion;
    public static volatile SingularAttribute<TFacturacion, Boolean> estado;
    public static volatile SingularAttribute<TFacturacion, String> facturaFinal;
    public static volatile SingularAttribute<TFacturacion, Long> idFacturacion;
    public static volatile SingularAttribute<TFacturacion, String> prefijo;
    public static volatile SingularAttribute<TFacturacion, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TFacturacion, String> facturaInicial;
    public static volatile SingularAttribute<TFacturacion, TSedes> idSede;
    public static volatile SingularAttribute<TFacturacion, String> facturaActual;
    public static volatile SingularAttribute<TFacturacion, String> fechaResolucion;
    public static volatile SingularAttribute<TFacturacion, String> numeroResolucion;

}