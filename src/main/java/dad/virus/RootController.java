package dad.virus;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootController implements Initializable {

    @FXML
    private Button configButton;

    @FXML
    private Button createGameButton;

    @FXML
    private Button documentationButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button joinGameButton;

    @FXML
    private Rectangle rectangleLogo;

    @FXML
    private StackPane stack;

    @FXML
    private BorderPane view;
    
    @FXML
    private WebView displayer;

    @FXML
    private VBox vboxrule;

    @FXML
    private GridPane viewrule;
    
    ControllerOptionsBox controller ;

    //JavaFX Media
    Media backgroundMusic;
    static MediaPlayer mediaPlay;

    //Switch view
    private Stage stage;
    private Scene scene;

    @FXML
    public void configAction(ActionEvent event) throws IOException {
        //Carga de la vista de opciones
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/optionsView.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        ControllerOptionsBox controller = loader.getController();
        scene.getStylesheets().add(App.getPrimaryStage().getScene().getStylesheets().get(0));

        //Listener para el slider del volumen
        controller.getVol().addListener((v, ov, nv) -> {
            mediaPlay.setVolume(Double.parseDouble(String.valueOf(nv.doubleValue() / 100).substring(0, 3)));
        });

        //Boton de reproducir men?? de opciones
        controller.getBtnPlayMusic().setOnAction((eventPlay) -> {
            playMedia();
        });

        //Bot??n de silencio men?? de opciones
        controller.getBtnSilence().setOnAction((eventSilence) -> {
            pauseMedia();
        });

        //Bot??n de guardar
        controller.getBtnSave().setOnAction((eventSave) -> {
            App.getPrimaryStage().getScene().getStylesheets().remove(
                    App.getPrimaryStage().getScene().getStylesheets().get(0));

            App.getPrimaryStage().getScene().getStylesheets().add(
                    String.valueOf(this.getClass().getResource(
                            controller.getURLcss().getValue())));
        });

        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("image/icon.jpg")));
            stage.setScene(scene);
            stage.showAndWait();
            stage.close();
        }catch (NullPointerException e){
        	
        }
    }
    	
    @FXML
    public void documentationAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/rulesView.fxml"));
    	stage.initModality(Modality.APPLICATION_MODAL);
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    public void exitAction(ActionEvent event) {
    	Platform.exit();
        System.exit(0);
    }

    @FXML
    void onCreateGameAction(ActionEvent event) {

    }

    @FXML
    void onJoinGameAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/boardView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,768);
        scene.getStylesheets().add(App.getPrimaryStage().getScene().getStylesheets().get(0));
        stage.setScene(scene);
        //stage.setMaximized(false);
        stage.show();
    }

    public RootController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
        loader.setController(this);
        loader.load();
        
    }

    public BorderPane getView() {
        return view;
    }

    private void setImageLogo() {
        //Im??gen logo
        Image img = new Image(this.getClass().getResource("/image/viruslogo.jpg").toString());
        rectangleLogo.setFill(new ImagePattern(img));
    }

    public void backgroundMusic() {
        //Musica de fondo
        try {
            backgroundMusic = new Media(App.class.getResource("/media/background-music.mp3").toURI().toString());
            mediaPlay = new MediaPlayer(backgroundMusic);
            mediaPlay.setAutoPlay(true);
            mediaPlay.setCycleCount(MediaPlayer.INDEFINITE);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void playMedia() {
        mediaPlay.play();
    }

    public void pauseMedia() {
        mediaPlay.stop();
    }

    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        setImageLogo();
        backgroundMusic();

    }
    
}
