package application.Model;

public class PedidoProduto {
    protected Integer codPed;
    protected Integer prodid;
    protected Integer quant;

    public Integer getCodPed() {
        return codPed;
    }

    public void setCodPed(Integer codPed) {
        this.codPed = codPed;
    }

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }
}
