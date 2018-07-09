package application.Controller;

import application.MController.ControllerFunc;
import application.Model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerAddFunc extends ControllerMaster{
    ObservableList<String> sexo = FXCollections.observableArrayList("Masculino","Feminino","Outro");
    @FXML
    public TextField cpfField;
    public TextField nomeField;
    public TextField idadeField;
    public TextField emailField;
    public TextField telField;
    public TextField endField;
    public ChoiceBox sexoField;
    Funcionario func = new Funcionario();
    ControllerFunc control = new ControllerFunc();


    public void initialize(){
        sexoField.setValue("Masculino");
        sexoField.setItems(sexo);
    }

    public void adicionar(){
        func.setCpf(cpfField.getText());
        func.setNome(nomeField.getText());
        func.setIdade(Integer.parseInt(idadeField.getText()));
        func.setEmail(emailField.getText());
        func.setTelefone(telField.getText());
        func.setEndereco(endField.getText());
        func.setSexo(sexoField.getValue().toString());
        control.addFunc(func);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        sexoField.setValue("Masculino");
    }

}
