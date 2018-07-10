package application.MController;

import application.Conecta;
import application.Model.Funcionario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerFunc {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param func objeto funcionario*/
    public void addFunc(Funcionario func){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into funcionario(cpf,nome,sexo,email,idade,telefone,endereco)values(?,?,?,?,?,?,?)");
            pst.setString(1,func.getCpf());
            pst.setString(2,func.getNome());
            pst.setString(3,func.getSexo());
            pst.setString(4,func.getEmail());
            pst.setInt(5,func.getIdade());
            pst.setString(6,func.getTelefone());
            pst.setString(7,func.getEndereco());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
    /**modifica os dados do banco de dados com os dados recebidos
     * @param func objeto funcionario*/
    public void modFunc(Funcionario func){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update funcionario set nome=?, sexo=?, email=?, idade=?, telefone=?, endereco=? where idfunc=? ");
            pst.setString(1,func.getNome());
            pst.setString(2,func.getSexo());
            pst.setString(3,func.getEmail());
            pst.setInt(4,func.getIdade());
            pst.setString(5,func.getTelefone());
            pst.setString(6,func.getEndereco());
            pst.setInt(7,func.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
    /**exclui os dados do banco de dados de acordo com os dados recebidos
     * @param func objeto funcionario*/
    public void excFunc(Funcionario func){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from funcionario where idfunc=?");
            pst.setInt(1,func.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
}
