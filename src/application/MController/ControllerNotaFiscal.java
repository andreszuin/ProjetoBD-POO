package application.MController;

import application.Conecta;
import application.Model.NotaFiscal;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerNotaFiscal {
    Conecta conex = new Conecta();
    private Integer cod;
    /**adiciona os dados recebidos ao banco de dados
     * @param nf objeto nota fiscal
     * @param prods lista de produtos*/
    public void criar(NotaFiscal nf,String prods){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into nota_fiscal(pedcod,valorrec,valortroco,impostos)values(?,?,?,?)");
            pst.setInt(1,nf.getPedCod());
            pst.setBigDecimal(2,nf.getValorRecebido());
            pst.setBigDecimal(3,nf.getValorTroco());
            pst.setBigDecimal(4,nf.getImpostos());
            pst.executeUpdate();
            conex.executa("select * from nota_fiscal where pedcod='" +nf.getPedCod()+"'");
            conex.rs.first();
            cod = conex.rs.getInt("nfcod");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
        JOptionPane.showMessageDialog(null,"Nota fiscal nº "+cod+"\nPedido nº "+nf.getPedCod()+"\n"+prods+"\nValor pago: "+nf.getValorRecebido()+"\nTroco: "+nf.getValorTroco()+"\nImpostos: "+nf.getImpostos());
    }
}
