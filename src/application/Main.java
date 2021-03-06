package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

public class Main extends Application {
	static Stage mainstage;
	/**modifica a tela que o usuario vê
	 * @param scene javafx scene*/
	public static void setStageScene(Scene scene){
		mainstage.setScene(scene);
	}

	public static Stage getStage(){
		return mainstage;
	}
	Conecta conex = new Conecta();
	@Override
	/**mostra a primeira tela do programa, realiza conexão inicial com o bd e cuida de fechar o programa e desconectar do banco de dados*/
	public void start(Stage primaryStage) {
		try {
			conex.conexao();
			Main.mainstage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface/Menu.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("Halo Games");
			Scene scene1 = new Scene(root);
			primaryStage.setScene(scene1);
			primaryStage.show();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {

					conex.desconnect();
					System.exit(0);
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}
