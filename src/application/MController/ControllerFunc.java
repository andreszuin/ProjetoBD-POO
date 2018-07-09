package application.MController;

import application.Conecta;
import application.Model.Funcionario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerFunc {
    Conecta conex = new Conecta();
    public void addFunc(Funcionario func){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into funcionario(cpf,nome,sexo,email,idade,telefone,endereço)values(?,?,?,?,?,?,?)");
            pst.setString(1,func.getCpf());
            pst.setString(2,func.getNome());
            pst.setString(3,func.getSexo());
            pst.setString(4,func.getEmail());
            pst.setInt(5,func.getIdade());
            pst.setString(6,func.getTelefone());
            pst.setString(7,func.getEndereco());
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao inserir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }

    public void modFunc(Funcionario func){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update funcionario set nome=?, sexo=?, email=?, idade=?, telefone=?, endereço=? where idfunc=? ");
            pst.setString(1,func.getNome());
            pst.setString(2,func.getSexo());
            pst.setString(3,func.getEmail());
            pst.setInt(4,func.getIdade());
            pst.setString(5,func.getTelefone());
            pst.setString(6,func.getEndereco());
            pst.setInt(7,func.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao modificar os dados\n erro:"+ex);
        }
        conex.desconnect();
    }

    public void excFunc(Funcionario func){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from funcionario where idfunc=?");
            pst.setInt(1,func.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir os dados\n erro:"+ex);
        }
        conex.desconnect();
    }
}
