package application.Controller;

import application.Conecta;
import application.MController.ControllerFunc;
import application.Model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;

public class ControllerModFunc extends ControllerMaster{
    ObservableList<String> sexo = FXCollections.observableArrayList("Masculino","Feminino","Outro");
    @FXML
    public TextField cpfField;
    public TextField nomeField;
    public TextField idadeField;
    public TextField emailField;
    public TextField telField;
    public TextField endField;
    public TextField idField;
    public ChoiceBox sexoField;
    Funcionario func = new Funcionario();
    ControllerFunc control = new ControllerFunc();

    Conecta conex = new Conecta();

    public void initialize(){
        sexoField.setItems(sexo);
    }

    public void encontrar(){
        conex.conexao();
        try{
            conex.executa("select * from funcionario where idfunc='" +Integer.parseInt(idField.getText())+"'");
            conex.rs.first();
            cpfField.setText(conex.rs.getString("cpf"));
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
        func.setNome(nomeField.getText());
        func.setIdade(Integer.parseInt(idadeField.getText()));
        func.setEmail(emailField.getText());
        func.setTelefone(telField.getText());
        func.setEndereco(endField.getText());
        func.setId(Integer.parseInt(idField.getText()));
        func.setSexo(sexoField.getValue().toString());
        control.modFunc(func);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        idField.setText(null);
        sexoField.setValue("Masculino");
    }

    public void excluir(){
        func.setId(Integer.parseInt(idField.getText()));
        control.excFunc(func);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        idField.setText(null);
        sexoField.setValue("Masculino");
    }

}
