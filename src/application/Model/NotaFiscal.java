package application.Model;

import java.math.BigDecimal;

public class NotaFiscal {
	/**classe modelo de nota fiscal*/
	protected Integer CodNF;
	protected Integer pedCod;
	protected BigDecimal valorRecebido;
	protected BigDecimal ValorTroco;
	protected BigDecimal Impostos;

	public Integer getCodNF() {
		return CodNF;
	}

	public void setCodNF(Integer codNF) {
		CodNF = codNF;
	}

	public Integer getPedCod() {
		return pedCod;
	}

	public void setPedCod(Integer pedCod) {
		this.pedCod = pedCod;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public BigDecimal getValorTroco() {
		return ValorTroco;
	}

	public void setValorTroco(Double total,Double recebido) {
		Double troc = (total+total*0.15)-recebido;
		ValorTroco = BigDecimal.valueOf(Math.abs(troc));
	}

	public BigDecimal getImpostos() {
		return Impostos;
	}

	public void setImpostos(Double total) {
		Impostos = BigDecimal.valueOf(total*0.15);
	}
}
