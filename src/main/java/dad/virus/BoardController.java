package dad.virus;

import dad.virus.game.Card;
import dad.virus.game.Deck;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private static Deck deck = new Deck();//Creacion de mazo
    private static Card[] mano;
    private static Card[] manoBot1;
    private static Card[] manoBot2;
    private static Card[] manoBot3;
    private static ArrayList<Card> descartes ;

    @FXML
    private HBox boardJ1;

    @FXML
    private HBox boardJ2;

    @FXML
    private HBox boardJ3;

    @FXML
    private HBox boardJ4;

    @FXML
    private GridPane boardView;

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button c1;

    @FXML
    private Button c2;

    @FXML
    private Button c3;

    @FXML
    private ImageView card1Stack1J1;

    @FXML
    private ImageView card1Stack1J2;

    @FXML
    private ImageView card1Stack1J3;

    @FXML
    private ImageView card1Stack1J4;

    @FXML
    private ImageView card1Stack2J1;

    @FXML
    private ImageView card1Stack2J2;

    @FXML
    private ImageView card1Stack2J3;

    @FXML
    private ImageView card1Stack2J4;

    @FXML
    private ImageView card1Stack3J1;

    @FXML
    private ImageView card1Stack3J2;

    @FXML
    private ImageView card1Stack3J3;

    @FXML
    private ImageView card1Stack3J4;

    @FXML
    private ImageView card1Stack4J1;

    @FXML
    private ImageView card1Stack4J2;

    @FXML
    private ImageView card1Stack4J3;

    @FXML
    private ImageView card1Stack4J4;

    @FXML
    private ImageView card2Stack1J1;

    @FXML
    private ImageView card2Stack1J2;

    @FXML
    private ImageView card2Stack1J3;

    @FXML
    private ImageView card2Stack1J4;

    @FXML
    private ImageView card2Stack2J1;

    @FXML
    private ImageView card2Stack2J2;

    @FXML
    private ImageView card2Stack2J3;

    @FXML
    private ImageView card2Stack2J4;

    @FXML
    private ImageView card2Stack3J1;

    @FXML
    private ImageView card2Stack3J2;

    @FXML
    private ImageView card2Stack3J3;

    @FXML
    private ImageView card2Stack3J4;

    @FXML
    private ImageView card2Stack4J1;

    @FXML
    private ImageView card2Stack4J2;

    @FXML
    private ImageView card2Stack4J3;

    @FXML
    private ImageView card2Stack4J4;

    @FXML
    private ImageView card3Stack1J1;

    @FXML
    private ImageView card3Stack1J2;

    @FXML
    private ImageView card3Stack1J3;

    @FXML
    private ImageView card3Stack1J4;

    @FXML
    private ImageView card3Stack2J1;

    @FXML
    private ImageView card3Stack2J2;

    @FXML
    private ImageView card3Stack2J3;

    @FXML
    private ImageView card3Stack2J4;

    @FXML
    private ImageView card3Stack3J1;

    @FXML
    private ImageView card3Stack3J2;

    @FXML
    private ImageView card3Stack3J3;

    @FXML
    private ImageView card3Stack3J4;

    @FXML
    private ImageView card3Stack4J1;

    @FXML
    private ImageView card3Stack4J21;

    @FXML
    private ImageView card3Stack4J3;

    @FXML
    private ImageView card3Stack4J4;

    @FXML
    private Circle circleTextPlayer1;

    @FXML
    private Circle circleTextPlayer2;

    @FXML
    private Circle circleTextPlayer3;

    @FXML
    private ImageView deckOfCards;

    @FXML
    private ImageView discardDeck;

    @FXML
    private ImageView handCard1;

    @FXML
    private ImageView handCard2;

    @FXML
    private ImageView handCard3;

    @FXML
    private ImageView j1image;

    @FXML
    private ImageView j2image;

    @FXML
    private ImageView j3image;

    @FXML
    private StackPane stackPane1J1;

    @FXML
    private StackPane stackPane1J2;

    @FXML
    private StackPane stackPane1J3;

    @FXML
    private StackPane stackPane1J4;

    @FXML
    private StackPane stackPane2J1;

    @FXML
    private StackPane stackPane2J2;

    @FXML
    private StackPane stackPane2J3;

    @FXML
    private StackPane stackPane2J4;

    @FXML
    private StackPane stackPane3J1;

    @FXML
    private StackPane stackPane3J2;

    @FXML
    private StackPane stackPane3J3;

    @FXML
    private StackPane stackPane3J4;

    @FXML
    private StackPane stackPane4J1;

    @FXML
    private StackPane stackPane4J3;

    @FXML
    private StackPane stackPane4J4;

    @FXML
    private Text txtJ1;

    @FXML
    private Text txtJ2;

    @FXML
    private Text txtJ3;

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

        Collections.shuffle(deck.getDeck());//Baraja de mazo
        mano = new Card[3];//Creacion de mano
        manoBot1 = new Card[3];
        manoBot2 = new Card[3];
        manoBot3 = new Card[3];

        mano[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        mano[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        mano[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot1[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        System.out.println(manoBot1[0]);

        manoBot1[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        System.out.println(manoBot1[1]);

        manoBot1[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        System.out.println(manoBot1[2]);

        manoBot2[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot2[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot2[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot3[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot3[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot3[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        descartes = new ArrayList<>();

        handCard1.setImage(mano[0].getImagen());
        handCard2.setImage(mano[1].getImagen());
        handCard3.setImage(mano[2].getImagen());


    }

    public static int randomNumber(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    @FXML
    void onc1action(ActionEvent event) {
        buttonAction(0);
        jueganBots(manoBot1,1);
        jueganBots(manoBot2,2);
        jueganBots(manoBot3,3);
    }

    @FXML
    void onc2action(ActionEvent event) {
        buttonAction(1);
        jueganBots(manoBot1,1);
        jueganBots(manoBot2,2);
        jueganBots(manoBot3,3);
    }

    @FXML
    void onc3action(ActionEvent event) {
        buttonAction(2);
        jueganBots(manoBot1,1);
        jueganBots(manoBot2,2);
        jueganBots(manoBot3,3);
    }

    public void mostrarmano(Card[] mano) {
        for(int i=0;i<mano.length;i++) {
            System.out.print(mano[i]);
        }
        System.out.println();
    }

    public void buttonAction(int i){
        switch(mano[i].getType().toString()) {

            case "ORGAN":
                useOrgan(i);
                break;
            case "HEAL":
                useVirusHeal(i);
                break;
            case "VIRUS":
                useVirusHeal(i);
                break;
        }

        mano[i] = null;
        mano[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        switch (i){
            case 0:
                handCard1.setImage(mano[i].getImagen());
                break;
            case 1:
                handCard2.setImage(mano[i].getImagen());
                break;
            case 2:
                handCard3.setImage(mano[i].getImagen());
                break;
        }

/*        mostrarmano(mano);
        System.out.println("Descartes " + descartes);
        System.out.println("Deck: " + deck.getDeck().size());*/
        if(deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.removeAll(descartes);
            Collections.shuffle(deck.getDeck());
        }
    }

    public void useOrgan(int aux) {
/*        mostrarmano(mano);
        System.out.println(descartes);*/
        switch (mano[aux].getColor().toString()){
            case "RED":
                if(card1Stack1J4.getImage()== null){
                    card1Stack1J4.setImage(mano[aux].getImagen());
                }else{
                    descartes.add(mano[aux]);
                    discardDeck.setImage(mano[aux].getImagen());
                }
                break;
            case "BLUE":
                if(card1Stack2J4.getImage()== null){
                    card1Stack2J4.setImage(mano[aux].getImagen());
                }else{
                    descartes.add(mano[aux]);
                    discardDeck.setImage(mano[aux].getImagen());
                }
                break;
            case "GREEN":
                if(card1Stack3J4.getImage()== null){
                    card1Stack3J4.setImage(mano[aux].getImagen());
                }else{
                    descartes.add(mano[aux]);
                    discardDeck.setImage(mano[aux].getImagen());
                }
                break;
            case "YELLOW":
                if(card1Stack4J4.getImage()== null){
                    card1Stack4J4.setImage(mano[aux].getImagen());
                }else{
                    descartes.add(mano[aux]);
                    discardDeck.setImage(mano[aux].getImagen());
                }
                break;
            default:
                discardDeck.setImage(new Image("/image/card/swapBody.png"));
                break;
        }
    }

    public void useVirusHeal(int aux) {
        //mostrarmano(mano);

        descartes.add(mano[aux]);
        discardDeck.setImage(mano[aux].getImagen());
    }

    public void jueganBots(Card manoBot[],int bot){
        if(deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.removeAll(descartes);
            Collections.shuffle(deck.getDeck());
        }
        if(manoBot[0].getType().toString().equals("ORGAN")){
            juegaOrganBot2(0, bot);
            renovarMano(manoBot, 0);
        }else if(manoBot[1].getType().toString().equals("ORGAN")) {
            juegaOrganBot2(1, bot);
            renovarMano(manoBot, 1);
        }else if(manoBot[2].getType().toString().equals("ORGAN")) {
            juegaOrganBot2(2, bot);
            renovarMano(manoBot, 2);
        }else{
            System.out.println("No había organo");
            useVirusHealBot();
        }

        if(deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.removeAll(descartes);
            Collections.shuffle(deck.getDeck());
        }
    }
    public void juegaOrganBot(int aux){
        switch (manoBot1[aux].getColor().toString()){
            case "RED":
                if(card1Stack1J1.getImage()== null){
                    card1Stack1J1.setImage(manoBot1[aux].getImagen());
                }else{
                    descartes.add(manoBot1[aux]);
                    discardDeck.setImage(manoBot1[aux].getImagen());
                }
                break;
            case "BLUE":
                if(card1Stack2J1.getImage()== null){
                    card1Stack2J1.setImage(manoBot1[aux].getImagen());
                }else{
                    descartes.add(manoBot1[aux]);
                    discardDeck.setImage(manoBot1[aux].getImagen());
                }
                break;
            case "GREEN":
                if(card1Stack3J1.getImage()== null){
                    card1Stack3J1.setImage(manoBot1[aux].getImagen());
                }else{
                    descartes.add(manoBot1[aux]);
                    discardDeck.setImage(manoBot1[aux].getImagen());
                }
                break;
            case "YELLOW":
                if(card1Stack4J1.getImage()== null){
                    card1Stack4J1.setImage(manoBot1[aux].getImagen());
                }else{
                    descartes.add(manoBot1[aux]);
                    discardDeck.setImage(manoBot1[aux].getImagen());
                }
                break;
            default:
                discardDeck.setImage(new Image("/image/card/swapBody.png"));
                break;
        }
        renovarMano(manoBot1,aux);
    }
    public void useVirusHealBot() {
        descartes.add(manoBot1[0]);
        renovarMano(manoBot1,0);
        discardDeck.setImage(manoBot1[0].getImagen());
    }
    public void renovarMano(Card manoX[], int i){
        manoX[i] = null;
        manoX[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        for(int j=0; j>manoX.length;j++){
            System.out.println(manoX[j]);
        }
    }

    public void juegaOrganBot2(int aux, int bot){
        if(bot==1) {
            switch (manoBot1[aux].getColor().toString()) {
                case "RED":
                    if (card1Stack1J1.getImage() == null) {
                        card1Stack1J1.setImage(manoBot1[aux].getImagen());
                    } else {
                        descartes.add(manoBot1[aux]);
                        discardDeck.setImage(manoBot1[aux].getImagen());
                    }
                    break;
                case "BLUE":
                    if (card1Stack2J1.getImage() == null) {
                        card1Stack2J1.setImage(manoBot1[aux].getImagen());
                    } else {
                        descartes.add(manoBot1[aux]);
                        discardDeck.setImage(manoBot1[aux].getImagen());
                    }
                    break;
                case "GREEN":
                    if (card1Stack3J1.getImage() == null) {
                        card1Stack3J1.setImage(manoBot1[aux].getImagen());
                    } else {
                        descartes.add(manoBot1[aux]);
                        discardDeck.setImage(manoBot1[aux].getImagen());
                    }
                    break;
                case "YELLOW":
                    if (card1Stack4J1.getImage() == null) {
                        card1Stack4J1.setImage(manoBot1[aux].getImagen());
                    } else {
                        descartes.add(manoBot1[aux]);
                        discardDeck.setImage(manoBot1[aux].getImagen());
                    }
                    break;
                default:
                    discardDeck.setImage(new Image("/image/card/swapBody.png"));
                    break;
            }
            renovarMano(manoBot1, aux);
        }else if(bot == 2){
            switch (manoBot2[aux].getColor().toString()) {
                case "RED":
                    if (card1Stack1J2.getImage() == null) {
                        card1Stack1J2.setImage(manoBot2[aux].getImagen());
                    } else {
                        descartes.add(manoBot2[aux]);
                        discardDeck.setImage(manoBot2[aux].getImagen());
                    }
                    break;
                case "BLUE":
                    if (card1Stack2J2.getImage() == null) {
                        card1Stack2J2.setImage(manoBot2[aux].getImagen());
                    } else {
                        descartes.add(manoBot2[aux]);
                        discardDeck.setImage(manoBot2[aux].getImagen());
                    }
                    break;
                case "GREEN":
                    if (card1Stack3J2.getImage() == null) {
                        card1Stack3J2.setImage(manoBot2[aux].getImagen());
                    } else {
                        descartes.add(manoBot2[aux]);
                        discardDeck.setImage(manoBot2[aux].getImagen());
                    }
                    break;
                case "YELLOW":
                    if (card1Stack4J2.getImage() == null) {
                        card1Stack4J2.setImage(manoBot2[aux].getImagen());
                    } else {
                        descartes.add(manoBot2[aux]);
                        discardDeck.setImage(manoBot2[aux].getImagen());
                    }
                    break;
                default:
                    discardDeck.setImage(new Image("/image/card/swapBody.png"));
                    break;
            }
            renovarMano(manoBot2, aux);

        }else if(bot == 3){
            switch (manoBot3[aux].getColor().toString()) {
                case "RED":
                    if (card1Stack1J3.getImage() == null) {
                        card1Stack1J3.setImage(manoBot3[aux].getImagen());
                    } else {
                        descartes.add(manoBot3[aux]);
                        discardDeck.setImage(manoBot3[aux].getImagen());
                    }
                    break;
                case "BLUE":
                    if (card1Stack2J3.getImage() == null) {
                        card1Stack2J3.setImage(manoBot3[aux].getImagen());
                    } else {
                        descartes.add(manoBot3[aux]);
                        discardDeck.setImage(manoBot3[aux].getImagen());
                    }
                    break;
                case "GREEN":
                    if (card1Stack3J3.getImage() == null) {
                        card1Stack3J3.setImage(manoBot3[aux].getImagen());
                    } else {
                        descartes.add(manoBot3[aux]);
                        discardDeck.setImage(manoBot3[aux].getImagen());
                    }
                    break;
                case "YELLOW":
                    if (card1Stack4J3.getImage() == null) {
                        card1Stack4J3.setImage(manoBot3[aux].getImagen());
                    } else {
                        descartes.add(manoBot3[aux]);
                        discardDeck.setImage(manoBot3[aux].getImagen());
                    }
                    break;
                default:
                    discardDeck.setImage(new Image("/image/card/swapBody.png"));
                    break;
            }
            renovarMano(manoBot3, aux);
        }
    }
}
