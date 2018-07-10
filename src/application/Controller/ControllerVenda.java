package application.Controller;

import application.Conecta;
import application.MController.ControllerNotaFiscal;
import application.MController.ControllerPedido;
import application.MController.ControllerPedidoProduto;
import application.Model.NotaFiscal;
import application.Model.Pedido;
import application.Model.PedidoProduto;
import application.Model.TabelaEstoque;
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
    public TableView<TabelaEstoque> tabela_estoque;
    public TableColumn<TabelaEstoque,Integer> colId;
    public TableColumn<TabelaEstoque,String> colNome;


    public void initialize(){
        atuTabela();
    }

    public void atuTabela(){
        colId.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,Integer>("Id"));
        colNome.setCellValueFactory(new PropertyValueFactory<TabelaEstoque,String>("nome"));
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
                TabelaEstoque tabm = new TabelaEstoque();
                tabm.setId(id);
                tabm.setNome(nome);
                membros.add(tabm);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro na coisinha de adicionar a tabela\nerro:"+ex);
        }
        conex.desconnect();
        return membros;
    }

    public void iniciarCompra(){
        p.setCpfC(cpfCli.getText());
        p.setIdF(Integer.parseInt(idFunc.getText()));
        p.setData(LocalDate.now());
        codPedido = controlP.addPedido(p);
        inicialPane.setVisible(false);
        vendaPane.setVisible(true);
    }

    public void adicionarItem(){
        pp.setCodPed(codPedido);
        pp.setProdid(Integer.parseInt(idField.getText()));
        controlPP.criar(pp);
        conex.conexao();
        try{
            conex.executa("select * from produto where prodid='" +Integer.parseInt(idField.getText())+ "'");
            conex.rs.first();
            nome = conex.rs.getString("nome");
            preco = conex.rs.getBigDecimal("preço").doubleValue();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao obter os dados\n erro:"+ex);
        }
        total+=preco;
        if(produtos==null){
            produtos=nome;
        }
        else {
            produtos += "\n" + nome;
        }
        totalField.setText(String.valueOf(total+total*0.15));
        produtosText.setText(produtos);
    }

    public void finalizarCompra(){
        p.setCod(codPedido);
        p.setPrecoF(BigDecimal.valueOf(total+total*0.15));
        controlP.addTotal(p);

        nf.setPedCod(codPedido);
        nf.setValorRecebido(BigDecimal.valueOf(Double.parseDouble(pagoField.getText())));
        nf.setValorTroco(BigDecimal.valueOf((total+total*0.15)-Double.parseDouble(pagoField.getText())));
        nf.setImpostos(BigDecimal.valueOf(total*0.15));
        controlNF.criar(nf);

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
