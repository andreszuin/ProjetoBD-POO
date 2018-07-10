package application.Controller;

import application.MController.ControllerPessoa;
import application.Model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerAddCliente extends ControllerMaster{
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
    /**inicializa a tela colocando os itens do choicebox e mostrando um valor padrão*/
    public void initialize(){
        sexoField.setValue("Masculino");
        sexoField.setItems(sexo);
    }
    /**envia os dados coletados na tela para um objeto do tipo pessoa, chama seu controlador para adicionar os dados ao banco de dados
     *  e limpa os Textfields*/
    public void adicionar(){
        cliente.setCpf(cpfField.getText());
        cliente.setNome(nomeField.getText());
        cliente.setIdade(Integer.parseInt(idadeField.getText()));
        cliente.setEmail(emailField.getText());
        cliente.setTelefone(telField.getText());
        cliente.setEndereco(endField.getText());
        cliente.setSexo(sexoField.getValue().toString());
        control.addCliente(cliente);
        cpfField.setText(null);
        nomeField.setText(null);
        idadeField.setText(null);
        emailField.setText(null);
        telField.setText(null);
        endField.setText(null);
        sexoField.setValue("Masculino");
    }



}
