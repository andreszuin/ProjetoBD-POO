package application.Controller;

import application.Conecta;
import application.MController.ControllerPessoa;
import application.Model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerModCliente extends ControllerMaster{
    ObservableList<String> sexo = FXCollections.observableArrayList("Masculino","Feminino","Outro");
    @FXML
    public TextField cpfField;
    public TextField nomeField;
    public TextField idadeField;
    public TextField emailField;
    public TextField telField;
    public TextField endField;
    public ChoiceBox sexoField;
    Pessoa cliente = new Pessoa();
    ControllerPessoa control = new ControllerPessoa();
    Conecta conex = new Conecta();

    public void initialize(){
        sexoField.setItems(sexo);
    }

    public void encontrar(){
        conex.conexao();
        try{
            conex.executa("select * from cliente where cpf='" +cpfField.getText()+"'");
            conex.rs.first();
            nomeField.setText(conex.rs.getString("nome"));
            sexoField.setValue(conex.rs.getString("sexo"));
            emailField.setText(conex.rs.getString("email"));
            idadeField.setText(String.valueOf(conex.rs.getInt("idade")));
            telField.setText(conex.rs.getString("telefone"));
            endField.setText(conex.rs.getString("endereço"));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }


    public void modificar(){
        cliente.setCpf(cpfField.getText());
        cliente.setNome(nomeField.getText());
        cliente.setIdade(Integer.parseInt(idadeField.getText()));
        cliente.setEmail(emailField.getText());
        cliente.setTelefone(telField.getText());
        cliente.setEndereco(endField.getText());
        cliente.setSexo(sexoField.getValue().toString());
        control.modCliente(cliente);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        sexoField.setValue("Masculino");
    }
    public void excluir(){
        cliente.setCpf(cpfField.getText());
        control.excCliente(cliente);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        sexoField.setValue("Masculino");
    }
}
