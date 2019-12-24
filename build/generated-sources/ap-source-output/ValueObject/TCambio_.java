package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import ValueObject.TTransacciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TCambio.class)
public class TCambio_ { 

    public static volatile SingularAttribute<TCambio, Double> valorRetirado;
    public static volatile SingularAttribute<TCambio, Boolean> sincronizacion;
    public static volatile SingularAttribute<TCambio, String> numeroFactura;
    public static volatile SingularAttribute<TCambio, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TCambio, Boolean> anulada;
    public static volatile SingularAttribute<TCambio, Double> redondeo;
    public static volatile SingularAttribute<TCambio, Integer> estadoTransaccion;
    public static volatile SingularAttribute<TCambio, TTransacciones> idTransaccion;
    public static volatile SingularAttribute<TCambio, Double> iva;
    public static volatile SingularAttribute<TCambio, Double> comision;
    public static volatile SingularAttribute<TCambio, Long> idTipoTransaccion;
    public static volatile SingularAttribute<TCambio, TSedes> idSede;
    public static volatile SingularAttribute<TCambio, Long> idCambio;
    public static volatile SingularAttribute<TCambio, String> codigoBarras;
    public static volatile SingularAttribute<TCambio, Date> fechaOperacion;

}