package dad.virus;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.layout.HBox;
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
import com.dansoftware.pdfdisplayer.PDFDisplayer;
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
    

    //JavaFX Media
    Media backgroundMusic;
    MediaPlayer mediaPlay;

    //Switch view
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void configAction(ActionEvent event) throws IOException {
        //Carga de la vista de opciones
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/optionsView.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        ControllerOptionsBox controller = loader.getController();

        //Listener para el slider del volumen
        controller.getVol().addListener((v,ov,nv) -> {
            mediaPlay.setVolume(Double.parseDouble(String.valueOf(nv.doubleValue()/100).substring(0, 3)));
        });

        //Boton de reproducir menú de opciones
        controller.getBtnPlayMusic().setOnAction((eventPlay) -> {
            playMedia();
        });

        //Botón de silencio menú de opciones
        controller.getBtnSilence().setOnAction((eventSilence) -> {
            pauseMedia();
        }) ;

        Stage stage = new Stage();

        scene.getStylesheets().add(String.valueOf(App.class.getResource("/css/viewOptions.css")));

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
    	Stage stage ;
    	Scene scene ;
    @FXML
    public void documentationAction(ActionEvent event) throws IOException {
  	
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/rulesView.fxml"));
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(App.class.getResource("/css/board.css")));
        stage.setScene(scene);
        stage.show();
    }

    public RootController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
        loader.setController(this);
        loader.load();
    }

    public BorderPane getView() {
        return view;
    }

    private void setImageLogo(){
        //Imágen logo
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

    public void playMedia(){
        mediaPlay.play();
    }

    public void pauseMedia(){
        mediaPlay.stop();
    }

    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
       setImageLogo();
       backgroundMusic();
    }
}
