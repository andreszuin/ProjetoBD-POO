package application.Controller;

import application.Conecta;
import application.Model.TabelaFuncionarios;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ControllerVerFunc extends ControllerMaster{
    public TableView<TabelaFuncionarios> tabela_funcionarios;
    public TableColumn<TabelaFuncionarios,Integer>colId;
    public TableColumn<TabelaFuncionarios,String> colNome;
    public TableColumn<TabelaFuncionarios,String>colCPF;
    Conecta conex = new Conecta();
    /**inicializa a pagina chamando a função para popular a tabela*/
    public void initialize(){
        atuTabela();
    }
    /**popula a tabela*/
    public void atuTabela(){
        colId.setCellValueFactory(new PropertyValueFactory<TabelaFuncionarios,Integer>("Id"));
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaFuncionarios,String>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<TabelaFuncionarios,String>("cpf"));
        tabela_funcionarios.getItems().setAll(lista());
    }
    /**cria uma lista com os itens necessarios para popular a tabela
     * @return membros da lista*/
    private List<TabelaFuncionarios> lista(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from funcionario");
            while(conex.rs.next()){
                Integer id = conex.rs.getInt(2);
                String nome = conex.rs.getString(3);
                String cpf = conex.rs.getString(1);
                TabelaFuncionarios tabm = new TabelaFuncionarios();
                tabm.setId(id);
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
