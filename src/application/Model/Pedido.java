package application.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    /**classe modelo de pedido*/
    protected Integer cod;
    protected String cpfC;
    protected Integer idF;
    protected LocalDate data;
    protected BigDecimal precoF;

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getCpfC() {
        return cpfC;
    }

    public void setCpfC(String cpfC) {
        this.cpfC = cpfC;
    }

    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getPrecoF() {
        return precoF;
    }

    public void setPrecoF(Double precoF) {
        this.precoF = BigDecimal.valueOf(precoF+ precoF*0.15);
    }
}
