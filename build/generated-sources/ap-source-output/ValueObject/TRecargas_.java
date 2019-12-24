package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import ValueObject.TTransacciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:50")
@StaticMetamodel(TRecargas.class)
public class TRecargas_ { 

    public static volatile SingularAttribute<TRecargas, Long> idRecarga;
    public static volatile SingularAttribute<TRecargas, String> descripcion;
    public static volatile SingularAttribute<TRecargas, Double> valorOperacion;
    public static volatile SingularAttribute<TRecargas, Boolean> sinccronizacion;
    public static volatile SingularAttribute<TRecargas, String> numeroFactura;
    public static volatile SingularAttribute<TRecargas, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TRecargas, String> lineaReferencia;
    public static volatile SingularAttribute<TRecargas, Integer> estadoTransaccion;
    public static volatile SingularAttribute<TRecargas, TTransacciones> idTransaccion;
    public static volatile SingularAttribute<TRecargas, Long> idTipoTransaccion;
    public static volatile SingularAttribute<TRecargas, TSedes> idSede;
    public static volatile SingularAttribute<TRecargas, String> operador;
    public static volatile SingularAttribute<TRecargas, Date> fechaOperacion;

}