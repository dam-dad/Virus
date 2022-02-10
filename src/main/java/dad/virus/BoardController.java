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

    @FXML
    private ImageView handCard1;

    @FXML
    private ImageView handCard2;

    @FXML
    private ImageView handCard3;

    @FXML
    private Button c1;

    @FXML
    private Button c2;

    @FXML
    private Button c3;

    private Stage stage;
    private Scene scene;

    @FXML
    void actionBackMenu(ActionEvent event) throws IOException {
    }


    @FXML
    void actionShowDeck(MouseEvent event) {

    }

    private void setImagePlayer() throws NullPointerException {
        boolean continua = true;
        while (continua) {
            try {
                String srcImg1 = this.getClass().getResource(("/image/players/p" + randomNumber(5, 7) + ".jpg")).toString();
                String srcImg2 = this.getClass().getResource(("/image/players/p" + randomNumber(0, 4) + ".jpg")).toString();
                circleTextPlayer1.setFill(new ImagePattern(new Image(srcImg1)));
                circleTextPlayer2.setFill(new ImagePattern(new Image(srcImg2)));
                continua = false;
            } catch (NullPointerException e) {
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImagePlayer();

        Image img = null;
        for (int tableroJugador = 1; tableroJugador <= 4; tableroJugador++) {
            HBox hBox = (HBox) boardView.getChildren().get(tableroJugador);
            for (int stackPaneJugador = 0; stackPaneJugador < 4; stackPaneJugador++) {
                StackPane stackPane = (StackPane) hBox.getChildren().get(stackPaneJugador);
                for (int j = 0; j < 3; j++) {
                    ImageView imageView = (ImageView) stackPane.getChildren().get(j);
                }

            }
        }

    }

    public static int randomNumber(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    @FXML
    void onc1action(ActionEvent event) {

    }

    @FXML
    void onc2action(ActionEvent event) {

    }

    @FXML
    void onc3action(ActionEvent event) {

    }
}
