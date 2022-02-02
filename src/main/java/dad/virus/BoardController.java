package dad.virus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    @FXML
    private HBox boardJ1;

    @FXML
    private HBox boardJ2;

    @FXML
    private HBox boardJ21;

    @FXML
    private HBox boardJ3;

    @FXML
    private GridPane boardView;

    @FXML
    private ImageView card1Stack1J1;

    @FXML
    private ImageView card1Stack1J2;

    @FXML
    private ImageView card1Stack1J3;

    @FXML
    private ImageView card1Stack2J1;

    @FXML
    private ImageView card1Stack2J2;

    @FXML
    private ImageView card1Stack2J3;

    @FXML
    private ImageView card1Stack3J1;

    @FXML
    private ImageView card1Stack3J2;

    @FXML
    private ImageView card1Stack3J3;

    @FXML
    private ImageView card1Stack4J1;

    @FXML
    private ImageView card1Stack4J2;

    @FXML
    private ImageView card1Stack4J3;

    @FXML
    private ImageView card2Stack1J1;

    @FXML
    private ImageView card2Stack1J2;

    @FXML
    private ImageView card2Stack1J3;

    @FXML
    private ImageView card2Stack2J1;

    @FXML
    private ImageView card2Stack2J2;

    @FXML
    private ImageView card2Stack2J3;

    @FXML
    private ImageView card2Stack3J1;

    @FXML
    private ImageView card2Stack3J2;

    @FXML
    private ImageView card2Stack3J3;

    @FXML
    private ImageView card2Stack4J1;

    @FXML
    private ImageView card2Stack4J2;

    @FXML
    private ImageView card2Stack4J3;

    @FXML
    private ImageView card3Stack1J1;

    @FXML
    private ImageView card3Stack1J2;

    @FXML
    private ImageView card3Stack1J3;

    @FXML
    private ImageView card3Stack2J1;

    @FXML
    private ImageView card3Stack2J2;

    @FXML
    private ImageView card3Stack2J3;

    @FXML
    private ImageView card3Stack3J1;

    @FXML
    private ImageView card3Stack3J2;

    @FXML
    private ImageView card3Stack3J3;

    @FXML
    private ImageView card3Stack4J1;

    @FXML
    private ImageView card3Stack4J21;

    @FXML
    private ImageView card3Stack4J3;

    @FXML
    private Circle circleTextPlayer2;

    @FXML
    private Circle circleTextPlayer1;

    @FXML
    private ImageView deckOfCards;

    @FXML
    private ImageView discardDeck;

    @FXML
    private ImageView j2image;

    @FXML
    private ImageView j2image1;

    @FXML
    private ImageView mazoJ3Image;

    @FXML
    private StackPane stackPane1J1;

    @FXML
    private StackPane stackPane1J2;

    @FXML
    private StackPane stackPane1J3;

    @FXML
    private StackPane stackPane2J1;

    @FXML
    private StackPane stackPane2J2;

    @FXML
    private StackPane stackPane2J3;

    @FXML
    private StackPane stackPane3J1;

    @FXML
    private StackPane stackPane3J2;

    @FXML
    private StackPane stackPane3J3;

    @FXML
    private StackPane stackPane4J1;

    @FXML
    private Text txtPlayer1;

    @FXML
    private Text txtPlayer2;

    @FXML
    private StackPane stackPanePlayer1;

    @FXML
    private Button btnBackMenu;

    private Stage stage;
    private Scene scene;

    @FXML
    void actionBackMenu(ActionEvent event) throws IOException {
    }


    @FXML
    void actionShowDeck(MouseEvent event) {

    }

    private void setImagePlayer() throws NullPointerException{
        boolean continua = true;
        while (continua) {
            try {
                String srcImg1 = this.getClass().getResource(("/image/players/p" + randomNumber(5, 7) + ".jpg")).toString();
                String srcImg2 = this.getClass().getResource(("/image/players/p" + randomNumber(0, 4) + ".jpg")).toString();
                circleTextPlayer1.setFill(new ImagePattern(new Image(srcImg1)));
                circleTextPlayer2.setFill(new ImagePattern(new Image(srcImg2)));
                continua = false;
            }catch (NullPointerException e){
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Player 1
        try {
            setImagePlayer();

            Image img = new Image(this.getClass().getResource("/image/Cartas/01.png").toURI().toString());
            card1Stack1J1.setImage(img);

            Image img20 = new Image(this.getClass().getResource("/image/Cartas/09.png").toString());
            card2Stack1J1.setImage(img20);
            Image img21 = new Image(this.getClass().getResource("/image/Cartas/18.png").toString());
            card3Stack1J1.setImage(img21);

            Image img2 = new Image(this.getClass().getResource("/image/Cartas/02.png").toString());
            card1Stack2J1.setImage(img2);

            Image img22 = new Image(this.getClass().getResource("/image/Cartas/19.png").toString());
            card2Stack2J1.setImage(img22);

            Image img3 = new Image(this.getClass().getResource("/image/Cartas/03.png").toString());
            card1Stack3J1.setImage(img3);

            Image img4 = new Image(this.getClass().getResource("/image/Cartas/04.png").toString());
            card1Stack4J1.setImage(img4);

            //Player2
            Image img5 = new Image(this.getClass().getResource("/image/Cartas/05.png").toString());
            card1Stack1J2.setImage(img5);

            Image img6 = new Image(this.getClass().getResource("/image/Cartas/06.png").toString());
            card1Stack2J2.setImage(img6);

            Image img7 = new Image(this.getClass().getResource("/image/Cartas/07.png").toString());
            card1Stack3J2.setImage(img7);

            Image img8 = new Image(this.getClass().getResource("/image/Cartas/08.png").toString());
            card1Stack4J2.setImage(img8);

            //Player 3
            Image img9 = new Image(this.getClass().getResource("/image/Cartas/09.png").toString());
            card1Stack1J3.setImage(img9);

            Image img10 = new Image(this.getClass().getResource("/image/Cartas/10.png").toString());
            card1Stack2J3.setImage(img10);

            Image img11 = new Image(this.getClass().getResource("/image/Cartas/11.png").toString());
            card1Stack3J3.setImage(img11);

            Image img12 = new Image(this.getClass().getResource("/image/Cartas/12.png").toString());
            card1Stack4J3.setImage(img12);

            Image img13 = new Image(this.getClass().getResource("/image/Cartas/14.png").toString());
            card2Stack4J2.setImage(img13);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static int randomNumber(int minimo,int maximo){
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }
}
