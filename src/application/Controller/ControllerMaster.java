package application.Controller;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public abstract class ControllerMaster {
    Parent root;
    Scene scene;
    /**controlador para o menu superior de todas as telas*/
    //menu
    /**abre a tela inicial*/
    public void OpenInicio() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Menu.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver o estoque*/
    public void OpenEstoque()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Estoque.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar itens*/
    public void OpenAddItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar itens*/
    public void OpenModItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela de vendas*/
    public void OpenVenda()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Venda.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver os funcionarios*/
    public void OpenVerFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar funcionarios*/
    public void OpenAddFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar funcionarios*/
    public void OpenModFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para ver os clientes*/
    public void OpenVerCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para adicionar clientes*/
    public void OpenAddCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    /**abre a tela para modificar clientes*/
    public void OpenModCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
}
