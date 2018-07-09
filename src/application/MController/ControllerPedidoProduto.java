package application.MController;

import application.Conecta;
import application.Model.PedidoProduto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerPedidoProduto {
    Conecta conex = new Conecta();
    public void criar(PedidoProduto pp){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into pedido_produto(pedcod,prodid)values(?,?)");
            pst.setInt(1,pp.getCodPed());
            pst.setInt(2,pp.getProdid());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
