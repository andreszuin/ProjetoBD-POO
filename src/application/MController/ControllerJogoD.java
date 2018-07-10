package application.MController;

import application.Conecta;
import application.Model.JogoDigital;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerJogoD {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param jd objeto jogo digital
     * @param id id do produto*/
    public void addJogoD(JogoDigital jd, Integer id){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into jogodigital(prodid,tamanho,jogokey,download)values(?,?,?,?)");
            pst.setInt(1,id);
            pst.setDouble(2,jd.getTamanho());
            pst.setString(3,jd.getKey());
            pst.setString(4,jd.getInstrucoes());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**modifica os dados do banco de dados com os dados recebidos
     * @param jd objeto jogo digital*/
    public void modJogoD(JogoDigital jd){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update produto set nome=?, preço=?, descrição=? where prodid=?");
            pst.setString(1,jd.getNome());
            pst.setBigDecimal(2,jd.getPreco());
            pst.setString(3,jd.getDescricao());
            pst.setInt(4,jd.getId());
            pst.execute();
            pst = conex.conn.prepareStatement("update jogo set produtora=?, genero=?, idioma=?, plataforma=?, anolançamento=? where prodid=?");
            pst.setString(1,jd.getProdutora());
            pst.setString(2,jd.getGenero());
            pst.setString(3,jd.getIdioma());
            pst.setString(4,jd.getPlataforma());
            pst.setInt(5,jd.getAnolancamento());
            pst.setInt(6,jd.getId());
            pst.execute();
            pst = conex.conn.prepareStatement("update jogodigital set tamanho=?, jogokey=?, download=? where prodid=?");
            pst.setDouble(1,jd.getTamanho());
            pst.setString(2,jd.getKey());
            pst.setString(3,jd.getInstrucoes());
            pst.setInt(4,jd.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao modificar os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**exclui os dados do banco de dados de acordo com os dados recebidos
     * @param jd objeto jogo digital*/
    public void excJogoD(JogoDigital jd){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from produto where prodid=?");
            pst.setInt(1,jd.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
