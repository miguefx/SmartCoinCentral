/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValueObject;

import java.text.DecimalFormat;

/**
 *
 * @author matc_
 */
public class TreporteMovimientos {

    private String idModulo;
    private Double valor;

    public TreporteMovimientos(String idModulo, Double valor) {
        this.idModulo = idModulo;
        this.valor = valor;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public Double getValor() {
        new DecimalFormat("###,###.###").format(valor);
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
