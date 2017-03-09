package org.mordraug.gw2orchestral.Gw2Orchestral;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXApp extends Application {
	Weld weld = new Weld();
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WeldContainer weldContainer = weld.initialize();
		weldContainer.select(FXApp.class).get().postWeldInit(primaryStage);
	}
	
	private void postWeldInit(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/editor.fxml"));
		Scene scene = new Scene(root, 1024, 768);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception{
		super.stop();
		weld.shutdown();
	}

}
