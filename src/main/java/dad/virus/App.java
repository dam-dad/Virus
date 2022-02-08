package dad.virus;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    private RootController controller;
    //private GameController controller;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
       App.primaryStage = primaryStage;
        // TODO Auto-generated method stub
        controller = new RootController();
        primaryStage.setTitle("Virus Game");
        primaryStage.setScene(new Scene(controller.getView()));
        App.getPrimaryStage().getScene().getStylesheets().add(getClass().getResource(controller.themeCSS.getValue()).toString());
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("image/icon.jpg")));
        primaryStage.show();
/*        App.primaryStage = primaryStage;
        controller = new GameController();
        primaryStage.setScene(new Scene(controller.getView()));
        primaryStage.show();*/
    }
}
