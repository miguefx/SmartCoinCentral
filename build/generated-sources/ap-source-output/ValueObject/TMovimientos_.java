package ValueObject;

import ValueObject.TArqueos;
import ValueObject.TCargas;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TMovimientos.class)
public class TMovimientos_ { 

    public static volatile SingularAttribute<TMovimientos, String> accion;
    public static volatile SingularAttribute<TMovimientos, TCargas> idCarga;
    public static volatile SingularAttribute<TMovimientos, Boolean> sincronizacion;
    public static volatile SingularAttribute<TMovimientos, Double> valor;
    public static volatile SingularAttribute<TMovimientos, String> idModulo;
    public static volatile SingularAttribute<TMovimientos, String> parte;
    public static volatile SingularAttribute<TMovimientos, TArqueos> idArqueo;
    public static volatile SingularAttribute<TMovimientos, Date> fechaMovimiento;
    public static volatile SingularAttribute<TMovimientos, BigInteger> idTransaccion;
    public static volatile SingularAttribute<TMovimientos, Double> denominacion;
    public static volatile SingularAttribute<TMovimientos, Long> idMovimiento;
    public static volatile SingularAttribute<TMovimientos, BigInteger> idSede;
    public static volatile SingularAttribute<TMovimientos, Integer> cantidad;

}