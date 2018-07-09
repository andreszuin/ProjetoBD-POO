package application.Controller;

import application.Conecta;
import application.Model.TabelaEstoque;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ControllerEstoque extends ControllerMaster{
    public TableView<TabelaEstoque> tabela_estoque;
    public TableColumn<TabelaEstoque,Integer> colId;
    public TableColumn<TabelaEstoque,String> colNome;
    public TableColumn<TabelaEstoque,String>colDesc;
    Conecta conex = new Conecta();
    public void initialize(){
        atuTabela();
    }

    public void atuTabela(){
        colId.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,Integer>("Id"));
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,String>("nome"));
        colDesc.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,String>("desc"));
        tabela_estoque.getItems().setAll(lista());
    }

    private List<TabelaEstoque> lista(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from produto");
            while(conex.rs.next()){
                Integer id = conex.rs.getInt(1);
                String nome = conex.rs.getString(2);
                String desc = conex.rs.getString(4);
                TabelaEstoque tabm = new TabelaEstoque();
                tabm.setId(id);
                tabm.setDesc(desc);
                tabm.setNome(nome);
                membros.add(tabm);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro na coisinha de adicionar a tabela\nerro:"+ex);
        }
        conex.desconnect();
        return membros;
    }
}
