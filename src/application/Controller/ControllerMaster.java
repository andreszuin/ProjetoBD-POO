package application.Controller;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class ControllerMaster {
    Parent root;
    Scene scene;
    //menu
    /**abre a tela inicial
     * @throws IOException erro ao abrir tela*/
    public void OpenInicio() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Menu.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver o estoque
     * @throws IOException erro ao abrir tela*/
    public void OpenEstoque()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Estoque.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar itens
     * @throws IOException erro ao abrir tela*/
    public void OpenAddItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar itens
     * @throws IOException erro ao abrir tela*/
    public void OpenModItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela de vendas
     * @throws IOException erro ao abrir tela*/
    public void OpenVenda()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Venda.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver os funcionarios
     * @throws IOException erro ao abrir tela*/
    public void OpenVerFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar funcionarios
     * @throws IOException erro ao abrir tela*/
    public void OpenAddFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar funcionarios
     * @throws IOException erro ao abrir tela*/
    public void OpenModFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver os clientes
     * @throws IOException erro ao abrir tela*/
    public void OpenVerCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar clientes
     * @throws IOException erro ao abrir tela*/
    public void OpenAddCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar clientes
     * @throws IOException erro ao abrir tela*/
    public void OpenModCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
}
