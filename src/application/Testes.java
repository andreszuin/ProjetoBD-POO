package application;


import application.Model.NotaFiscal;
import application.Model.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;

public class Testes {
    /**classe de teste junit*/
    Pedido p = new Pedido();
    NotaFiscal nf = new NotaFiscal();
    @Test
    /**realiza o teste de calculo do valor final na classe pedido*/
    public void precoFTest(){
        Double valor = 300.00;
        Double esperado = 345.00;
        p.setPrecoF(valor);
        Double real = p.getPrecoF().doubleValue();
        assertEquals(esperado,real,0);
    }
    @Test
    /**realiza o teste de calculo do imposto na classe nota fiscal*/
    public void impostoTest(){
        Double valor = 300.00;
        Double esperado = 45.00;
        nf.setImpostos(valor);
        Double real = nf.getImpostos().doubleValue();
        assertEquals(esperado,real,0);
    }
    @Test
    /**realiza o teste de calculo do troco na classe nota fiscal*/
    public void trocoTest(){
        Double valor = 300.00;
        Double valor2 = 400.00;
        Double esperado = 55.00;
        nf.setValorTroco(valor,valor2);
        Double real = nf.getValorTroco().doubleValue();
        assertEquals(esperado,real,0);
    }

}
