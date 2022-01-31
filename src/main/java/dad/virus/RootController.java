package dad.virus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RootController implements Initializable {

    @FXML
    private Button configButton;

    @FXML
    private Button documentationButton;

    @FXML
    private Button exitButton;

    @FXML
    private HBox hbox;

    @FXML
    private Button multiPlayerButton;

    @FXML
    private StackPane stack;

    @FXML
    private BorderPane view;

    //JavaFX Media
    AudioClip audioClip;
    Media backgroundMusic;

    @FXML
    private Rectangle rectangleLogo;

    @FXML
    public void configAction(ActionEvent event) {

    }

    @FXML
    public void documentationAction(ActionEvent event) {

    }

    @FXML
    public void exitAction(ActionEvent event) {

    }

    @FXML
    public void multiPlayerAction(ActionEvent event) {

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
            audioClip = new AudioClip(backgroundMusic.getSource());

            //TODO Realizar listener del slider para el control del volumen

            audioClip.setVolume(0.1f); // Volumen entre 0 y 1
            audioClip.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void playMedia(){
        audioClip.play();
    }

    public void pauseMedia(){
        audioClip.stop();
    }

    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
       setImageLogo();
       backgroundMusic();
    }
}
