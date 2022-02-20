package dad.virus;

import dad.virus.game.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import static dad.virus.game.Color.*;
import static dad.virus.game.Type.HEAL;
import static dad.virus.game.Type.VIRUS;

public class BoardController implements Initializable {

    private static Deck deck = new Deck();//Creacion de mazo
    private static Card[] mano;
    private static Card[] manoBot1;
    private static Card[] manoBot2;
    private static Card[] manoBot3;
    private static Organ[] playerBody;
    private static Organ[] bot1Body;
    private static Organ[] bot2Body;
    private static Organ[] bot3Body;
    private static ArrayList<Card> descartes;
    private static String url = "/image/players/inmune.png";

    @FXML
    private HBox boardJ2, boardJ4;

    @FXML
    private VBox boardJ1, boardJ3;

    @FXML
    private GridPane boardView;

    @FXML
    private Button btnBackMenu, c1, c2, c3, o1j1Button, o1j2Button, o1j3Button, o1j4Button, o2j1Button, o2j2Button, o2j3Button, o2j4Button, o3j1Button,
            o3j3Button, o3j4Button, o4j1Button, o4j3Button, o4j4Button;

    @FXML
    private ImageView card1Stack1J1, card1Stack1J2, card1Stack1J3, card1Stack1J4, card1Stack2J1, card1Stack2J2, card1Stack2J3, card1Stack2J4,
            card1Stack3J1, card1Stack3J2, card1Stack3J3, card1Stack3J4, card1Stack4J1, card1Stack4J2, card1Stack4J3, card1Stack4J4, card2Stack1J1, card2Stack1J2,
            card2Stack1J3, card2Stack1J4, card2Stack2J1, card2Stack2J2, card2Stack2J3, card2Stack2J4, card2Stack3J1, card2Stack3J2, card2Stack3J3, card2Stack3J4,
            card2Stack4J1, card2Stack4J2, card2Stack4J3, card2Stack4J4, deckOfCards, discardDeck, handCard1, handCard2, handCard3, j1image, j2image, j3image;

    @FXML
    private Circle circleTextPlayer1, circleTextPlayer2, circleTextPlayer3;


    @FXML
    private StackPane stackPane1J1, stackPane1J2, stackPane1J3, stackPane1J4, stackPane2J1, stackPane2J2, stackPane2J3, stackPane2J4, stackPane3J1, stackPane3J2, stackPane3J3, stackPane4J2, stackPane3J4, stackPane4J1, stackPane4J3, stackPane4J4;

    @FXML
    private Text txtJ1, txtJ2, txtJ3;

    private Stage stage;
    private Scene scene;

    private void setImagePlayer() throws NullPointerException {
        boolean continua = true;
        while (continua) {
            try {
                String srcImg1 = this.getClass().getResource(("/image/players/p" + randomNumber(6, 7) + ".jpg")).toString();
                String srcImg2 = this.getClass().getResource(("/image/players/p" + randomNumber(3, 5) + ".jpg")).toString();
                String srcImg3 = this.getClass().getResource(("/image/players/p" + randomNumber(0, 2) + ".jpg")).toString();
                circleTextPlayer1.setFill(new ImagePattern(new Image(srcImg1)));
                circleTextPlayer2.setFill(new ImagePattern(new Image(srcImg2)));
                circleTextPlayer3.setFill(new ImagePattern(new Image(srcImg3)));
                continua = false;
            } catch (NullPointerException e) {
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImagePlayer();
        playerBody = new Organ[4];
        bot1Body = new Organ[4];
        bot2Body = new Organ[4];
        bot3Body = new Organ[4];

        playerBody[0] = new Organ(RED);
        playerBody[1] = new Organ(BLUE);
        playerBody[2] = new Organ(GREEN);
        playerBody[3] = new Organ(YELLOW);

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


        manoBot1[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        manoBot1[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

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

        System.out.println(descartes.size());


    }

    public static int randomNumber(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    @FXML
    void onc1action(ActionEvent event) {
        buttonAction(0);
        jueganBots(manoBot1);
        jueganBots(manoBot2);
        jueganBots(manoBot3);
        System.out.println(descartes.size());
    }

    @FXML
    void onc2action(ActionEvent event) {
        buttonAction(1);
        jueganBots(manoBot1);
        jueganBots(manoBot2);
        jueganBots(manoBot3);
    }

    @FXML
    void onc3action(ActionEvent event) {
        buttonAction(2);
        jueganBots(manoBot1);
        jueganBots(manoBot2);
        jueganBots(manoBot3);
    }

    @FXML
    void onO1j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(RED, stackPane1J4))
            juegatodosBot();
    }

    @FXML
    void onO2j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(BLUE, stackPane2J4))
            juegatodosBot();
    }

    @FXML
    void onO3j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(GREEN, stackPane3J4))
            juegatodosBot();
    }

    @FXML
    void onO4j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(YELLOW, stackPane4J4))
            juegatodosBot();
    }

    @FXML
    void onO1j1Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J1))
            juegatodosBot();
    }

    @FXML
    void onO1j2Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J2))
            juegatodosBot();
    }

    @FXML
    void onO1j3Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J3))
            juegatodosBot();
    }


    @FXML
    void onO2j2Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J2))
            juegatodosBot();
    }

    @FXML
    void onO2j1Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J1))
            juegatodosBot();
    }

    @FXML
    void onO2j3Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J3))
            juegatodosBot();
    }

    @FXML
    void onO3j1Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J1))
            juegatodosBot();
    }

    @FXML
    void onO3j2Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J2))
            juegatodosBot();
    }

    @FXML
    void onO3j3Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J3))
            juegatodosBot();
    }

    @FXML
    void onO4j1Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J1))
            juegatodosBot();
    }

    @FXML
    void onO4j2Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J2))
            juegatodosBot();
    }

    @FXML
    void onO4j3Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J3))
            juegatodosBot();
    }


    public void checkDeck() {
        System.out.println(deck.getDeck());
        System.out.println(deck.getDeck().size());
        if (deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.clear();
            Collections.shuffle(deck.getDeck());
        }
    }

    public void juegatodosBot() {
        checkDeck();
        if (jueganBots(manoBot1))
            if (jueganBots(manoBot2))
                jueganBots(manoBot3);
    }

    public void buttonAction(int i) {
        checkDeck();
        mano[i] = null;
        mano[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        switch (i) {
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
    }

    public boolean jueganBots(Card manoBot[]) {
        boolean haJugado = false;
        checkDeck();
        if (manoBot[0].getType().toString().equals("ORGAN")) {
            juegaOrganBot(manoBot,0);
            renovarMano(manoBot, 0);
            haJugado = true;
        } else if (manoBot[1].getType().toString().equals("ORGAN")) {
            juegaOrganBot(manoBot,1);
            renovarMano(manoBot, 1);
            haJugado = true;
        } else if (manoBot[2].getType().toString().equals("ORGAN")) {
            juegaOrganBot(manoBot,2);
            renovarMano(manoBot, 2);
            haJugado = true;
        } else {
            if(!useHealBot(manoBot)){
                useVirusHealBot(manoBot);
                haJugado = true;
            }
        }
        return haJugado;
    }

    public boolean useHealBot(Card manoBot[]){
        boolean haJugado = false;
        StackPane o1 = new StackPane();
        StackPane o2 = new StackPane();
        StackPane o3 = new StackPane();
        StackPane o4 = new StackPane();
        ImageView temporal = new ImageView();

        if(manoBot.equals(manoBot1)){
            o1 = stackPane1J1;
            o2 = stackPane2J1;
            o3 = stackPane3J1;
            o4 = stackPane4J1;
        }else if(manoBot.equals(manoBot2)){
            o1 = stackPane1J2;
            o2 = stackPane2J2;
            o3 = stackPane3J2;
            o4 = stackPane4J2;
        }else if(manoBot.equals(manoBot3)){
            o1 = stackPane1J3;
            o2 = stackPane2J3;
            o3 = stackPane3J3;
            o4 = stackPane4J3;
        }
        Button button = (Button) o1.getChildren().get(0);
        temporal = (ImageView) button.getGraphic();
        ImageView imageHeal = (ImageView) o1.getChildren().get(1);
        if(temporal.getImage()!=null){
            if(getIndex(manoBot,HEAL, RED)!=-1){
                imageHeal.setImage(manoBot[getIndex(manoBot,HEAL, RED)].getImagen());
                haJugado=true;
            }else{
                button = (Button) o2.getChildren().get(0);
                temporal = (ImageView) button.getGraphic();
                imageHeal = (ImageView) o2.getChildren().get(1);
                if(temporal.getImage()!=null) {
                    if (getIndex(manoBot, HEAL, BLUE) != -1) {
                        imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, BLUE)].getImagen());
                        haJugado = true;
                    }
                }else{
                    button = (Button) o3.getChildren().get(0);
                    temporal = (ImageView) button.getGraphic();
                    imageHeal = (ImageView) o3.getChildren().get(1);
                    if(temporal.getImage()!=null) {
                        if (getIndex(manoBot, HEAL, GREEN) != -1) {
                            imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, GREEN)].getImagen());
                            haJugado = true;
                        }
                    }else{
                        button = (Button) o4.getChildren().get(0);
                        temporal = (ImageView) button.getGraphic();
                        imageHeal = (ImageView) o4.getChildren().get(1);
                        if(temporal.getImage()!=null) {
                            if (getIndex(manoBot, HEAL, YELLOW) != -1) {
                                imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, YELLOW)].getImagen());
                                haJugado = true;
                            }
                        }
                    }
                }
            }
        }
        return haJugado;
    }

    public int getIndex(Card manoX[], Type type, Color color){
        int index = -1;
        for (int i = 0; i < manoX.length; i++) {
            if(manoX[i].getType()==type && manoX[i].getColor()==color){
                index = i;
            }
        }
        return index;
    }

    public void useVirusHealBot(Card manoBot[]) {
        descartes.add(manoBot[0]);
        renovarMano(manoBot, 0);
        discardDeck.setImage(manoBot[0].getImagen());
    }

    public void renovarMano(Card manoX[], int i) {
        checkDeck();
        manoX[i] = null;
        manoX[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
    }

    public void renovarMiMano(int i) {
        checkDeck();
        descartes.add(mano[i]);
        mano[i] = null;
        mano[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        switch (i) {
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
    }

    public void juegaOrganBot(Card manoBot[], int aux) {
        ImageView o1 = new ImageView();
        ImageView o2 = new ImageView();
        ImageView o3 = new ImageView();
        ImageView o4 = new ImageView();

        if(manoBot.equals(manoBot1)){
            o1 = card1Stack1J1;
            o2 = card1Stack2J1;
            o3 = card1Stack3J1;
            o4 = card1Stack4J1;
        }else if(manoBot.equals(manoBot2)){
            o1 = card1Stack1J2;
            o2 = card1Stack2J2;
            o3 = card1Stack3J2;
            o4 = card1Stack4J2;
        }else if(manoBot.equals(manoBot3)){
            o1 = card1Stack1J3;
            o2 = card1Stack2J3;
            o3 = card1Stack3J3;
            o4 = card1Stack4J3;
        }
        switch (manoBot[aux].getColor().toString()) {
            case "RED":
                if (o1.getImage() == null) {
                    o1.setImage(manoBot[aux].getImagen());
                } else {
                    descartes.add(manoBot[aux]);
                    discardDeck.setImage(manoBot[aux].getImagen());
                }
                break;
            case "BLUE":
                if (o2.getImage() == null) {
                    o2.setImage(manoBot[aux].getImagen());
                } else {
                    descartes.add(manoBot[aux]);
                    discardDeck.setImage(manoBot[aux].getImagen());
                }
                break;
            case "GREEN":
                if (o3.getImage() == null) {
                    o3.setImage(manoBot[aux].getImagen());
                } else {
                    descartes.add(manoBot[aux]);
                    discardDeck.setImage(manoBot[aux].getImagen());
                }
                break;
            case "YELLOW":
                if (o4.getImage() == null) {
                    o4.setImage(manoBot[aux].getImagen());
                } else {
                    descartes.add(manoBot[aux]);
                    discardDeck.setImage(manoBot[aux].getImagen());
                }
                break;
            default:
                discardDeck.setImage(new Image("/image/card/swapBody.png"));
                break;
        }
    }

    public boolean useVirus(Color color, StackPane stack) {
        boolean haJugado = false;
        Button button = (Button) stack.getChildren().get(0);
        ImageView image = (ImageView) button.getGraphic();
        ImageView imageVirus = (ImageView) stack.getChildren().get(1);
        if (image.getImage() != null) {
            try{
                if(imageVirus.getImage().getUrl().charAt(imageVirus.getImage().getUrl().length()-5)=='S'){
                    imageVirus.setImage(null);
                    image.setImage(null);
                    haJugado=true;
                    descartes.add(new Organ(color));
                    descartes.add(new Virus(color));
                    renovarMiMano(getIndex(mano,VIRUS, color));
                }else if(imageVirus.getImage().getUrl().charAt(imageVirus.getImage().getUrl().length()-5)=='L'){
                    imageVirus.setImage(null);
                    descartes.add(new Heal(color));
                    renovarMiMano(getIndex(mano,VIRUS, color));
                }
            }catch (NullPointerException e){
                if (mano[0].getColor() == color && mano[0].getType() == Type.VIRUS) {
                    imageVirus.setImage(mano[0].getImagen());
                    renovarMiMano(0);
                    haJugado = true;
                } else if (mano[1].getColor() == color && mano[1].getType() == Type.VIRUS) {
                    imageVirus.setImage(mano[1].getImagen());
                    renovarMiMano(1);
                    haJugado = true;
                } else if (mano[2].getColor() == color && mano[2].getType() == Type.VIRUS) {
                    imageVirus.setImage(mano[2].getImagen());
                    renovarMiMano(2);
                    haJugado = true;
                }
            }
        }
        return haJugado;
    }

    public boolean juegaPlayer(Color color, StackPane stack) {
        Boolean haJugado = false;
        Button button = (Button) stack.getChildren().get(0);
        ImageView image = (ImageView) button.getGraphic();
        ImageView imageHeal = (ImageView) stack.getChildren().get(1);
        if (image.getImage() == null) {
            if (mano[0].getColor() == color && mano[0].getType() == Type.ORGAN) {
                image.setImage(mano[0].getImagen());
                renovarMiMano(0);
                haJugado = true;
            } else if (mano[1].getColor() == color && mano[1].getType() == Type.ORGAN) {
                image.setImage(mano[1].getImagen());
                renovarMiMano(1);
                haJugado = true;
            } else if (mano[2].getColor() == color && mano[2].getType() == Type.ORGAN) {
                image.setImage(mano[2].getImagen());
                renovarMiMano(2);
                haJugado = true;
            }
        } else {
            if (imageHeal.getImage() == null) {
                if (mano[0].getColor() == color && mano[0].getType() == HEAL) {
                    imageHeal.setImage(mano[0].getImagen());
                    renovarMiMano(0);
                    haJugado = true;
                } else if (mano[1].getColor() == color && mano[1].getType() == HEAL) {
                    imageHeal.setImage(mano[1].getImagen());
                    renovarMiMano(1);
                    haJugado = true;
                } else if (mano[2].getColor() == color && mano[2].getType() == HEAL) {
                    imageHeal.setImage(mano[2].getImagen());
                    renovarMiMano(2);
                    haJugado = true;
                }
            } else {
                if ((imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5)) == 'L') {
                    if (mano[0].getColor() == color && mano[0].getType() == HEAL) {
                        imageHeal.setImage(new Image(url));
                        renovarMiMano(0);
                        haJugado = true;
                    } else if (mano[1].getColor() == color && mano[1].getType() == HEAL) {
                        imageHeal.setImage(new Image(url));
                        renovarMiMano(1);
                        haJugado = true;
                    } else if (mano[2].getColor() == color && mano[2].getType() == HEAL) {
                        imageHeal.setImage(new Image(url));
                        renovarMiMano(2);
                        haJugado = true;
                    }
                } else if ((imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5)) == 'S') {
                    imageHeal.setImage(null);
                    haJugado = true;
                }
            }
        }
        return haJugado;
    }
}