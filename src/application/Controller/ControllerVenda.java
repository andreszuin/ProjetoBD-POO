package application.Controller;

import application.Conecta;
import application.MController.ControllerNotaFiscal;
import application.MController.ControllerPedido;
import application.MController.ControllerPedidoProduto;
import application.Model.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ControllerVenda extends ControllerMaster{
    public TextField idField;
    public TextField totalField;
    public TextField idFunc;
    public TextField cpfCli;
    public TextField pagoField;
    public TextField qtdField;
    private Integer codPedido;
    private String nome;
    private String produtos=null;
    private Double preco;
    private Double total=0.00;
    public Pane vendaPane;
    public Pane inicialPane;
    public TextArea produtosText;
    Pedido p = new Pedido();
    Conecta conex = new Conecta();
    ControllerPedido controlP = new ControllerPedido();
    PedidoProduto pp = new PedidoProduto();
    ControllerPedidoProduto controlPP = new ControllerPedidoProduto();
    NotaFiscal nf = new NotaFiscal();
    ControllerNotaFiscal controlNF = new ControllerNotaFiscal();
    //estoque
    public TableView<TabelaEstoque> tabela_estoque;
    public TableColumn<TabelaEstoque,Integer> colIdE;
    public TableColumn<TabelaEstoque,String> colNomeE;
    //funcionarios
    public TableView<TabelaFuncionarios> tabela_funcionarios;
    public TableColumn<TabelaFuncionarios,Integer>colIdF;
    public TableColumn<TabelaFuncionarios,String> colNomeF;
    //clientes
    public TableView<TabelaClientes> tabela_clientes;
    public TableColumn<TabelaClientes,String> colNomeC;
    public TableColumn<TabelaClientes,String>colCPFC;
    /**inicializa a pagina e chama as funções de popular as tabelas*/
    public void initialize(){
        atuTabelaE();
        atuTabelaF();
        atuTabelaC();
    }
    /**popula a tabela de produtos*/
    public void atuTabelaE(){
        colIdE.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,Integer>("Id"));
        colNomeE.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,String>("nome"));
        tabela_estoque.getItems().setAll(listaE());
    }
    /**cria a lista com os itens para popular a tabela de produtos
     * @return membros da lista*/
    private List<TabelaEstoque> listaE(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from produto");
            while(conex.rs.next()){
                Integer id = conex.rs.getInt(1);
                String nome = conex.rs.getString(2);
                TabelaEstoque tabm = new TabelaEstoque();
                tabm.setId(id);
                tabm.setNome(nome);
                membros.add(tabm);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao adicionar na tabela\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return membros;
    }
    /**popula a tabela de funcionarios*/
    public void atuTabelaF(){
        colIdF.setCellValueFactory(new PropertyValueFactory<TabelaFuncionarios,Integer>("Id"));
        colNomeF.setCellValueFactory(new PropertyValueFactory<TabelaFuncionarios,String>("nome"));
        tabela_funcionarios.getItems().setAll(listaF());
    }
    /**cria a lista com os itens para popular a tabela de funcionarios
     * @return membros da lista*/
    private List<TabelaFuncionarios> listaF(){
        conex.conexao();
        List membros = new LinkedList();
        try{
            conex.executa("select * from funcionario");
            while(conex.rs.next()){
                Integer id = conex.rs.getInt(2);
                String nome = conex.rs.getString(3);
                TabelaFuncionarios tabm = new TabelaFuncionarios();
                tabm.setId(id);
                tabm.setNome(nome);
                membros.add(tabm);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao adicionar na tabela\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return membros;
    }
    /**popula a tabela de clientes*/
    public void atuTabelaC(){
        colNomeC.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("nome"));
        colCPFC.setCellValueFactory(new PropertyValueFactory<TabelaClientes,String>("cpf"));
        tabela_clientes.getItems().setAll(listaC());
    }
    /**cria a lista com os itens para popular a tabela de clientes
     * @return membros da lista*/
    private List<TabelaClientes> listaC(){
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
    /**testa para ver se os campos estao preenchidos, apos isso adiciona os dados para um objeto do tipo pedido, chama seu controlador para
     * adicionar os dados ao banco de dados, recebe o codigo do pedido de volta e abre a tela para continuar a transação*/
    public void iniciarCompra(){
        try {
            if(idFunc.getText().equals("") || cpfCli.getText().equals("")){
                throw new CampoNulloException("Um dos campos esta vazio");
            }
            p.setCpfC(cpfCli.getText());
            p.setIdF(Integer.parseInt(idFunc.getText()));
            p.setData(LocalDate.now());
            codPedido = controlP.addPedido(p);
            inicialPane.setVisible(false);
            vendaPane.setVisible(true);
        }catch(CampoNulloException cn){
            JOptionPane.showMessageDialog(null,"Um dos campos esta vazio, preencha todos.","Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**adiciona um produto para um objeto do tipo pedidoproduto, chama o controlador para adicionar os dados ao banco de dados
     * , resgata o preço e nome do produto para adicionar ao valor total e lista de produtos respectivamente e mostra ambos na tela*/
    public void adicionarItem(){
        pp.setCodPed(codPedido);
        pp.setProdid(Integer.parseInt(idField.getText()));
        pp.setQuant(Integer.parseInt(qtdField.getText()));
        controlPP.criar(pp);
        conex.conexao();
        try{
            conex.executa("select * from produto where prodid='" +Integer.parseInt(idField.getText())+ "'");
            conex.rs.first();
            nome = conex.rs.getString("nome");
            preco = conex.rs.getBigDecimal("preco").doubleValue();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao obter dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        total+=preco*Integer.parseInt(qtdField.getText());
        if(produtos==null){
            produtos=nome+" "+qtdField.getText()+"  "+String.valueOf(preco*Integer.parseInt(qtdField.getText()));
        }
        else {
            produtos += "\n" + nome+"       "+qtdField.getText()+"       "+String.valueOf(preco*Integer.parseInt(qtdField.getText()));
        }
        totalField.setText(String.valueOf(total+total*0.15));
        produtosText.setText(produtos);
    }
    /**envia o preço final para um objeto do tipo pedido e chama seu controlador para adicionar o dados ao banco de dados, envia os dados
     * necessário para um objeto do tipo nota fiscal e chama seu controlador para adicionar os dados ao banco de dados, volta a tela para
     * a inicial da venda e limpa os TextField*/
    public void finalizarCompra(){
        p.setCod(codPedido);
        p.setPrecoF(total);
        controlP.addTotal(p);

        nf.setPedCod(codPedido);
        nf.setValorRecebido(BigDecimal.valueOf(Double.parseDouble(pagoField.getText())));
        nf.setValorTroco(total,Double.parseDouble(pagoField.getText()));
        nf.setImpostos(total);
        controlNF.criar(nf,produtos);
        produtos = null;
        total = 0.00;
        vendaPane.setVisible(false);
        inicialPane.setVisible(true);
        cpfCli.setText(null);
        idFunc.setText(null);
        totalField.setText(null);
        idField.setText(null);
        pagoField.setText(null);
        produtosText.setText(null);
    }
}
