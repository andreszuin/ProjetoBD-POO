package application.MController;

import application.Conecta;
import application.Model.JogoDigital;
import application.Model.JogoFisico;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerJogoF {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param jf objeto jogo fisico
     * @param id id do produto*/
    public void addJogoF(JogoFisico jf,Integer id){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into jogofisico(prodid,qtdestoque)values(?,?)");
            pst.setInt(1,id);
            pst.setInt(2,jf.getEstq());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**modifica os dados do banco de dados com os dados recebidos
     * @param jf objeto jogo fisico*/
    public void modJogoF(JogoFisico jf){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update produto set nome=?, preço=?, descrição=? where prodid=?");
            pst.setString(1,jf.getNome());
            pst.setBigDecimal(2,jf.getPreco());
            pst.setString(3,jf.getDescricao());
            pst.setInt(4,jf.getId());
            pst.execute();
            pst = conex.conn.prepareStatement("update jogo set produtora=?, genero=?, idioma=?, plataforma=?, anolançamento=? where prodid=?");
            pst.setString(1,jf.getProdutora());
            pst.setString(2,jf.getGenero());
            pst.setString(3,jf.getIdioma());
            pst.setString(4,jf.getPlataforma());
            pst.setInt(5,jf.getAnolancamento());
            pst.setInt(6,jf.getId());
            pst.execute();
            pst = conex.conn.prepareStatement("update jogofisico set qtdestoque=? where prodid=?");
            pst.setInt(1,jf.getEstq());
            pst.setInt(2,jf.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao modificar os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**exclui os dados do banco de dados de acordo com os dados recebidos
     * @param jf objeto jogo fisico*/
    public void excJogoF(JogoFisico jf){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from produto where prodid=?");
            pst.setInt(1,jf.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
