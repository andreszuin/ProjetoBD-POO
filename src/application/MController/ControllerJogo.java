package application.MController;

import application.Conecta;
import application.Model.Jogo;
import application.Model.JogoDigital;
import application.Model.JogoFisico;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerJogo {
    Conecta conex = new Conecta();
    JogoFisico jf = new JogoFisico();
    ControllerJogoF controlF = new ControllerJogoF();
    JogoDigital jd = new JogoDigital();
    ControllerJogoD controlD = new ControllerJogoD();
    /**adiciona os dados recebidos ao banco de dados e chama o controlador de jogo fisico para adicionar dados ao banco de dados*/
    public void addJogo(Jogo j, JogoFisico jf){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into produto(nome,preço,descrição)values(?,?,?)");
            pst.setString(1,j.getNome());
            pst.setBigDecimal(2,j.getPreco());
            pst.setString(3,j.getDescricao());
            pst.executeUpdate();
            conex.executa("select * from produto where nome='" +j.getNome()+"'");
            conex.rs.first();
            Integer id = conex.rs.getInt("prodid");
            pst = conex.conn.prepareStatement("insert into jogo(prodid,produtora,genero,idioma,plataforma,anolançamento)values(?,?,?,?,?,?)");
            pst.setInt(1,id);
            pst.setString(2,j.getProdutora());
            pst.setString(3,j.getGenero());
            pst.setString(4,j.getIdioma());
            pst.setString(5,j.getPlataforma());
            pst.setInt(6,j.getAnolancamento());
            pst.executeUpdate();
            controlF.addJogoF(jf,id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**adiciona os dados recebidos ao banco de dados e chama o controlador de jogo digital para adicionar dados ao banco de dados*/
    public void addJogo(Jogo j, JogoDigital jd){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into produto(nome,preço,descrição)values(?,?,?)");
            pst.setString(1,j.getNome());
            pst.setBigDecimal(2,j.getPreco());
            pst.setString(3,j.getDescricao());
            pst.executeUpdate();
            conex.executa("select * from produto where nome='" +j.getNome()+"'");
            conex.rs.first();
            Integer id = conex.rs.getInt("prodid");
            pst = conex.conn.prepareStatement("insert into jogo(prodid,produtora,genero,idioma,plataforma,anolançamento)values(?,?,?,?,?,?)");
            pst.setInt(1,id);
            pst.setString(2,j.getProdutora());
            pst.setString(3,j.getGenero());
            pst.setString(4,j.getIdioma());
            pst.setString(5,j.getPlataforma());
            pst.setInt(6,j.getAnolancamento());
            pst.executeUpdate();
            controlD.addJogoD(jd,id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**adiciona os dados recebidos ao banco de dados e chama os controladores de jogo fisico e digital para adicionar dados ao banco de dados*/
    public void addJogo(Jogo j, JogoFisico jf, JogoDigital jd){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into produto(nome,preço,descrição)values(?,?,?)");
            pst.setString(1,j.getNome());
            pst.setBigDecimal(2,j.getPreco());
            pst.setString(3,j.getDescricao());
            pst.executeUpdate();
            conex.executa("select * from produto where nome='" +j.getNome()+"'");
            conex.rs.first();
            Integer id = conex.rs.getInt("prodid");
            pst = conex.conn.prepareStatement("insert into jogo(prodid,produtora,genero,idioma,plataforma,anolançamento)values(?,?,?,?,?,?)");
            pst.setInt(1,id);
            pst.setString(2,j.getProdutora());
            pst.setString(3,j.getGenero());
            pst.setString(4,j.getIdioma());
            pst.setString(5,j.getPlataforma());
            pst.setInt(6,j.getAnolancamento());
            pst.executeUpdate();
            controlF.addJogoF(jf,id);
            controlD.addJogoD(jd,id);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
