package ValueObject;

import ValueObject.TAlarmas;
import ValueObject.TArqueos;
import ValueObject.TCambio;
import ValueObject.TCargas;
import ValueObject.TDonaciones;
import ValueObject.TEventos;
import ValueObject.TFacturacion;
import ValueObject.TParametros;
import ValueObject.TPartes;
import ValueObject.TRecargas;
import ValueObject.TSedes;
import ValueObject.TTipoModulo;
import ValueObject.TTransacciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TConfiguracion.class)
public class TConfiguracion_ { 

    public static volatile SingularAttribute<TConfiguracion, TTipoModulo> idTipoModulo;
    public static volatile SingularAttribute<TConfiguracion, Integer> extension;
    public static volatile SingularAttribute<TConfiguracion, Boolean> estado;
    public static volatile ListAttribute<TConfiguracion, TArqueos> tArqueosList;
    public static volatile SingularAttribute<TConfiguracion, String> ip;
    public static volatile SingularAttribute<TConfiguracion, String> idModulo;
    public static volatile ListAttribute<TConfiguracion, TAlarmas> tAlarmasList;
    public static volatile SingularAttribute<TConfiguracion, String> mac;
    public static volatile ListAttribute<TConfiguracion, TRecargas> tRecargasList;
    public static volatile ListAttribute<TConfiguracion, TTransacciones> tTransaccionesList;
    public static volatile ListAttribute<TConfiguracion, TFacturacion> tFacturacionList;
    public static volatile ListAttribute<TConfiguracion, TParametros> tParametrosList;
    public static volatile ListAttribute<TConfiguracion, TCargas> tCargasList;
    public static volatile ListAttribute<TConfiguracion, TEventos> tEventosList;
    public static volatile SingularAttribute<TConfiguracion, TSedes> idSede;
    public static volatile ListAttribute<TConfiguracion, TCambio> tCambioList;
    public static volatile ListAttribute<TConfiguracion, TPartes> tPartesList;
    public static volatile ListAttribute<TConfiguracion, TDonaciones> tDonacionesList;

}