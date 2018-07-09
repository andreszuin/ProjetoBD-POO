package application.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaClientes {
    private StringProperty Cpf;
    public void setCpf(String cpf){
        CpfProperty().set(cpf);
    }
    public String getCpf(){
        return CpfProperty().get();
    }
    public StringProperty CpfProperty(){
        if(Cpf == null){
            Cpf = new SimpleStringProperty(this,"Cpf");
        }
        return Cpf;
    }
    private StringProperty Nome;
    public void setNome(String nome){
        NomeProperty().set(nome);
    }
    public String getNome(){
        return NomeProperty().get();
    }

    public StringProperty NomeProperty() {
        if(Nome == null){
            Nome = new SimpleStringProperty(this,"Nome");
        }
        return Nome;
    }
}
