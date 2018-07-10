package application.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaEstoque {
    /**classe da tabela de produtos para transformar os dados recebidos*/
    private IntegerProperty Id;
    public void setId(Integer id){
        IdProperty().set(id);
    }
    public Integer getId(){
        return IdProperty().get();
    }
    public IntegerProperty IdProperty(){
        if(Id == null){
            Id = new SimpleIntegerProperty(this,"Id");
        }
        return Id;
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

    private StringProperty Desc;
    public void setDesc(String desc){
        DescProperty().set(desc);
    }
    public String getDesc(){
        return DescProperty().get();
    }
    public StringProperty DescProperty(){
        if(Desc == null){
            Desc = new SimpleStringProperty(this,"Desc");
        }
        return Desc;
    }
}
