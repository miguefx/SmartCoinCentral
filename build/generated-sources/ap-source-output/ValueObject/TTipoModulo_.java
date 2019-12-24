package ValueObject;

import ValueObject.TConfiguracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TTipoModulo.class)
public class TTipoModulo_ { 

    public static volatile SingularAttribute<TTipoModulo, Long> idTipoModulo;
    public static volatile SingularAttribute<TTipoModulo, Boolean> estado;
    public static volatile ListAttribute<TTipoModulo, TConfiguracion> tConfiguracionList;
    public static volatile SingularAttribute<TTipoModulo, String> tipoModulo;

}