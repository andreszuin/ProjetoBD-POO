package application.Controller;

import application.Conecta;
import application.Model.TabelaClientes;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ControllerVerCliente extends ControllerMaster{
    public TableView<TabelaClientes> tabela_clientes;
    public TableColumn<TabelaClientes,String> colNome;
    public TableColumn<TabelaClientes,String>colCPF;
    Conecta conex = new Conecta();
    public void initialize(){
        atuTabela();
    }

    public void atuTabela(){
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("cpf"));
        tabela_clientes.getItems().setAll(lista());
    }

    private List<TabelaClientes> lista(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from cliente");
            while(conex.rs.next()){
                String nome = conex.rs.getString(2);
                String cpf = conex.rs.getString(1);
                TabelaClientes tabm = new TabelaClientes();
                tabm.setCpf(cpf);
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
