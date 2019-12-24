package ValueObject;

import ValueObject.TCambio;
import ValueObject.TConfiguracion;
import ValueObject.TDonaciones;
import ValueObject.TRecargas;
import ValueObject.TSedes;
import ValueObject.TTipoTransaccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TTransacciones.class)
public class TTransacciones_ { 

    public static volatile SingularAttribute<TTransacciones, Double> totalPagado;
    public static volatile SingularAttribute<TTransacciones, Boolean> sincronizacion;
    public static volatile SingularAttribute<TTransacciones, Boolean> sincronizacionPago;
    public static volatile SingularAttribute<TTransacciones, String> numeroFactura;
    public static volatile SingularAttribute<TTransacciones, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TTransacciones, Boolean> anulada;
    public static volatile ListAttribute<TTransacciones, TRecargas> tRecargasList;
    public static volatile SingularAttribute<TTransacciones, Long> idTransaccion;
    public static volatile SingularAttribute<TTransacciones, Double> redondeo;
    public static volatile SingularAttribute<TTransacciones, Integer> estadoTransaccion;
    public static volatile SingularAttribute<TTransacciones, Date> fechaTransaccion;
    public static volatile SingularAttribute<TTransacciones, Double> valorRecibido;
    public static volatile SingularAttribute<TTransacciones, Double> iva;
    public static volatile SingularAttribute<TTransacciones, Double> comision;
    public static volatile SingularAttribute<TTransacciones, TTipoTransaccion> idTipoTransaccion;
    public static volatile SingularAttribute<TTransacciones, TSedes> idSede;
    public static volatile ListAttribute<TTransacciones, TCambio> tCambioList;
    public static volatile SingularAttribute<TTransacciones, String> codigoBarras;
    public static volatile ListAttribute<TTransacciones, TDonaciones> tDonacionesList;

}