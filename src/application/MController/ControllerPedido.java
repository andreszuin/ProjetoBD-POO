package application.MController;

import application.Conecta;
import application.Model.Pedido;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerPedido {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados*/
    public int addPedido(Pedido p){
        conex.conexao();
        Integer cod=0;
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into pedido(cpfcomprador,idfunc,datacompra)values(?,?,?)");
            pst.setString(1,p.getCpfC());
            pst.setInt(2,p.getIdF());
            pst.setDate(3, Date.valueOf(p.getData()));
            pst.executeUpdate();
            conex.executa("select * from pedido where cpfcomprador='" +p.getCpfC()+"' and idfunc='"+p.getIdF()+"' and datacompra='"+Date.valueOf(p.getData())+"'");
            conex.rs.first();
            cod = conex.rs.getInt("pedcod");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
        return cod;
    }
    /**adiciona os dados recebidos ao banco de dados*/
    public void addTotal(Pedido p){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update pedido set preçofinal=? where pedcod=?");
            pst.setBigDecimal(1,p.getPrecoF());
            pst.setInt(2,p.getCod());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao modificar os dados\n erro:"+ex);
        }
    }
}
