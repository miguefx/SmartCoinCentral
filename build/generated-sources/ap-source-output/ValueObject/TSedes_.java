package ValueObject;

import ValueObject.TAlarmas;
import ValueObject.TArqueos;
import ValueObject.TCambio;
import ValueObject.TCargas;
import ValueObject.TCiudades;
import ValueObject.TConfiguracion;
import ValueObject.TDonaciones;
import ValueObject.TEventos;
import ValueObject.TFacturacion;
import ValueObject.TPaises;
import ValueObject.TParametros;
import ValueObject.TPartes;
import ValueObject.TRecargas;
import ValueObject.TTransacciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TSedes.class)
public class TSedes_ { 

    public static volatile SingularAttribute<TSedes, Boolean> estado;
    public static volatile ListAttribute<TSedes, TConfiguracion> tConfiguracionList;
    public static volatile ListAttribute<TSedes, TArqueos> tArqueosList;
    public static volatile SingularAttribute<TSedes, TPaises> idPais;
    public static volatile SingularAttribute<TSedes, String> direccion;
    public static volatile SingularAttribute<TSedes, String> usuarioAsigando;
    public static volatile ListAttribute<TSedes, TAlarmas> tAlarmasList;
    public static volatile SingularAttribute<TSedes, String> nombre;
    public static volatile SingularAttribute<TSedes, TCiudades> idCiudad;
    public static volatile ListAttribute<TSedes, TRecargas> tRecargasList;
    public static volatile ListAttribute<TSedes, TTransacciones> tTransaccionesList;
    public static volatile ListAttribute<TSedes, TFacturacion> tFacturacionList;
    public static volatile ListAttribute<TSedes, TParametros> tParametrosList;
    public static volatile ListAttribute<TSedes, TCargas> tCargasList;
    public static volatile SingularAttribute<TSedes, Long> idSede;
    public static volatile ListAttribute<TSedes, TEventos> tEventosList;
    public static volatile ListAttribute<TSedes, TCambio> tCambioList;
    public static volatile SingularAttribute<TSedes, String> telefonoContacto;
    public static volatile ListAttribute<TSedes, TPartes> tPartesList;
    public static volatile ListAttribute<TSedes, TDonaciones> tDonacionesList;

}