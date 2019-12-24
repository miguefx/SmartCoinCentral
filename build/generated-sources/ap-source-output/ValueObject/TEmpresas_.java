package ValueObject;

import ValueObject.TUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-27T19:59:49")
@StaticMetamodel(TEmpresas.class)
public class TEmpresas_ { 

    public static volatile SingularAttribute<TEmpresas, Long> idEmpresa;
    public static volatile ListAttribute<TEmpresas, TUsuarios> tUsuariosList;
    public static volatile SingularAttribute<TEmpresas, String> empresa;

}