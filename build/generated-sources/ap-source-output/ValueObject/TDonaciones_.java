package ValueObject;

import ValueObject.TConfiguracion;
import ValueObject.TSedes;
import ValueObject.TTransacciones;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TDonaciones.class)
public class TDonaciones_ { 

    public static volatile SingularAttribute<TDonaciones, Double> valorOperacion;
    public static volatile SingularAttribute<TDonaciones, TTransacciones> idTransaccion;
    public static volatile SingularAttribute<TDonaciones, String> fundacion;
    public static volatile SingularAttribute<TDonaciones, Boolean> sincronizacion;
    public static volatile SingularAttribute<TDonaciones, Long> idDonacion;
    public static volatile SingularAttribute<TDonaciones, Long> idTipoTransaccion;
    public static volatile SingularAttribute<TDonaciones, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TDonaciones, TSedes> idSede;
    public static volatile SingularAttribute<TDonaciones, Date> fechaOperacion;

}