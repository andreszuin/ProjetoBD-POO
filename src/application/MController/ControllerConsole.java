package application.MController;

import application.Conecta;
import application.Model.Console;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerConsole {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param con objeto console*/
    public void addConsole(Console con){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into produto(nome,preco,descricao)values(?,?,?)");
            pst.setString(1,con.getNome());
            pst.setBigDecimal(2,con.getPreco());
            pst.setString(3,con.getDescricao());
            pst.executeUpdate();
            conex.executa("select * from produto where nome='" +con.getNome()+"'");
            conex.rs.first();
            Integer id = conex.rs.getInt("prodid");
            pst = conex.conn.prepareStatement("insert into console(prodid,marca,cor,hd,qntcontrole,qntestoque)values(?,?,?,?,?,?)");
            pst.setInt(1,id);
            pst.setString(2,con.getMarca());
            pst.setString(3,con.getCor());
            pst.setString(4,con.getMemoria());
            pst.setInt(5,con.getCtrls());
            pst.setInt(6,con.getEstq());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
    /**modifica os dados do banco de dados com os dados recebidos
     * @param con objeto console*/
    public void modConsole(Console con){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update produto set nome=?, preco=?, descricao=? where prodid=?");
            pst.setString(1,con.getNome());
            pst.setBigDecimal(2,con.getPreco());
            pst.setString(3,con.getDescricao());
            pst.setInt(4,con.getId());
            pst.execute();
            pst = conex.conn.prepareStatement("update console set marca=?, cor=?, hd=?, qntcontrole=?, qntestoque=? where prodid=?");
            pst.setString(1,con.getMarca());
            pst.setString(2,con.getCor());
            pst.setString(3,con.getMemoria());
            pst.setInt(4,con.getCtrls());
            pst.setInt(5,con.getEstq());
            pst.setInt(6,con.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao modificar dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
    /**exclui os dados do banco de dados de acordo com os dados recebidos
     * @param con objeto console*/
    public void excConsole(Console con){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from produto where prodid=?");
            pst.setInt(1,con.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
}
