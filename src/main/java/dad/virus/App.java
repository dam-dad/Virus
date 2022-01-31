package dad.virus;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	private RootController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		controller = new RootController();
		
		primaryStage.setTitle("Virus Game");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();
	}
	
}
