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
public class TreporteTransacciones {

    private String idModulo;
    private Integer conteo;
    private Double valorTotal;

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        new DecimalFormat("###,###.###").format(valorTotal);
        this.valorTotal = valorTotal;
    }

    public TreporteTransacciones(String idModulo, Integer conteo, Double valorTotal) {
        this.idModulo = idModulo;
        this.conteo = conteo;
        this.valorTotal = valorTotal;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public Integer getConteo() {
        new DecimalFormat("###,###.###").format(conteo);
        return conteo;
    }

    public void setConteo(Integer conteo) {
        this.conteo = conteo;
    }

}
