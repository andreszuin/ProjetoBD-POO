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
    /**inicializa a pagina chamando a função para popular a tabela*/
    public void initialize(){
        atuTabela();
    }
    /**popula a tabela*/
    public void atuTabela(){
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("cpf"));
        tabela_clientes.getItems().setAll(lista());
    }
    /**cria uma lista com os itens necessarios para popular a tabela
     * @return membros da lista*/
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
            JOptionPane.showMessageDialog(null,"Erro ao adicionar na tabela\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return membros;
    }
}
