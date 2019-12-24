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

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:50")
@StaticMetamodel(TArqueos.class)
public class TArqueos_ { 

    public static volatile SingularAttribute<TArqueos, Double> producido;
    public static volatile SingularAttribute<TArqueos, Character> tipo;
    public static volatile SingularAttribute<TArqueos, Double> conteo;
    public static volatile SingularAttribute<TArqueos, BigInteger> idLocal;
    public static volatile SingularAttribute<TArqueos, Boolean> sincronizacion;
    public static volatile SingularAttribute<TArqueos, BigInteger> idUsuario;
    public static volatile SingularAttribute<TArqueos, Double> valor;
    public static volatile SingularAttribute<TArqueos, Integer> cantTransacciones;
    public static volatile SingularAttribute<TArqueos, TConfiguracion> idModulo;
    public static volatile SingularAttribute<TArqueos, Long> idArqueo;
    public static volatile SingularAttribute<TArqueos, Date> fechaFin;
    public static volatile ListAttribute<TArqueos, TMovimientos> tMovimientosList;
    public static volatile SingularAttribute<TArqueos, Date> fechaInicio;
    public static volatile SingularAttribute<TArqueos, Date> fechaFinAnterior;
    public static volatile SingularAttribute<TArqueos, TSedes> idSede;

}