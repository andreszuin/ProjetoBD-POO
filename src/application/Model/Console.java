package application.Model;

public class Console extends Produto{
    protected String marca;
    protected String cor;
    protected String memoria;
    protected Integer ctrls;
    protected Integer estq;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public Integer getCtrls() {
        return ctrls;
    }

    public void setCtrls(Integer ctrls) {
        this.ctrls = ctrls;
    }

    public Integer getEstq() {
        return estq;
    }

    public void setEstq(Integer estq) {
        this.estq = estq;
    }
}
