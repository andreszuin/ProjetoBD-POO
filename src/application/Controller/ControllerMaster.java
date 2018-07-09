package application.Controller;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ControllerMaster {
    Parent root;
    Scene scene;
    //menu
    public void OpenInicio() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Menu.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenEstoque()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Estoque.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenAddItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenModItem()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModItem.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenVenda()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/Venda.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenVerFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenAddFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenModFunc()throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModFunc.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenVerCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/VerCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenAddCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/AddCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
    public void OpenModCliente() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/application/Interface/ModCliente.fxml"));
        scene = new Scene(root);
        Main.setStageScene(scene);
    }
}
