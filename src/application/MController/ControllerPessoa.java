package application.MController;

import application.Conecta;
import application.Model.Pessoa;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerPessoa {
    Conecta conex = new Conecta();
    /**adiciona os dados recebidos ao banco de dados
     * @param cliente objeto pessoa*/
    public void addCliente(Pessoa cliente){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into cliente(cpf,nome,sexo,email,idade,telefone,endereço)values(?,?,?,?,?,?,?)");
            pst.setString(1,cliente.getCpf());
            pst.setString(2,cliente.getNome());
            pst.setString(3,cliente.getSexo());
            pst.setString(4,cliente.getEmail());
            pst.setInt(5,cliente.getIdade());
            pst.setString(6,cliente.getTelefone());
            pst.setString(7,cliente.getEndereco());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**modifica os dados do banco de dados com os dados recebidos
     * @param cliente objeto pessoa*/
    public void modCliente(Pessoa cliente){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update cliente set nome=?, sexo=?, email=?, idade=?, telefone=?, endereço=? where cpf=? ");
            pst.setString(1,cliente.getNome());
            pst.setString(2,cliente.getSexo());
            pst.setString(3,cliente.getEmail());
            pst.setInt(4,cliente.getIdade());
            pst.setString(5,cliente.getTelefone());
            pst.setString(6,cliente.getEndereco());
            pst.setString(7,cliente.getCpf());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao modificar os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
    /**exclui os dados do banco de dados de acordo com os dados recebidos
     * @param cliente objeto pessoa*/
    public void excCliente(Pessoa cliente){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from cliente where cpf=?");
            pst.setString(1,cliente.getCpf());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
