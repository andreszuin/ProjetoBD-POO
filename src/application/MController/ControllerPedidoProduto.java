package application.MController;

import application.Conecta;
import application.Model.PedidoProduto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerPedidoProduto {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param pp objeto pedido produto*/
    public void criar(PedidoProduto pp){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into pedido_produto(pedcod,prodid,quant)values(?,?,?)");
            pst.setInt(1,pp.getCodPed());
            pst.setInt(2,pp.getProdid());
            pst.setInt(3,pp.getQuant());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
