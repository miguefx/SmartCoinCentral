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
public class TreporteArqueos {

    private String idModulo;
    private Double valor2;

    public TreporteArqueos(String idModulo, Double valor2) {
        this.idModulo = idModulo;
        this.valor2 = valor2;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public Double getValor() {
        return valor2;
    }

    public void setValor(Double valor) {
        this.valor2 = valor;
    }

}
