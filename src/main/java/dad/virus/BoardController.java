package dad.virus;

import dad.virus.game.*;
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
import javafx.scene.layout.*;
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

import static dad.virus.game.Color.*;

public class BoardController implements Initializable {

    private static Deck deck = new Deck();//Creacion de mazo
    private static Card[] mano;
    private static Card[] manoBot1;
    private static Card[] manoBot2;
    private static Card[] manoBot3;
    private static Organ[] playerBody;
    private static ArrayList<Card> descartes;

    @FXML
    private HBox boardJ1,boardJ2,boardJ3,boardJ4;

    @FXML
    private GridPane boardView;

    @FXML
    private Button btnBackMenu,c1,c2,c3,o1j1Button,o1j2Button,o1j3Button,o1j4Button,o2j1Button,o2j2Button,o2j3Button,o2j4Button,o3j1Button,
    o3j3Button,o3j4Button,o4j1Button,o4j3Button,o4j4Button;

    @FXML
    private ImageView card1Stack1J1,card1Stack1J2,card1Stack1J3,card1Stack1J4,card1Stack2J1,card1Stack2J2,card1Stack2J3,card1Stack2J4,
    card1Stack3J1,card1Stack3J2,card1Stack3J3,card1Stack3J4,card1Stack4J1,card1Stack4J2,card1Stack4J3,card1Stack4J4,card2Stack1J1,card2Stack1J2,
    card2Stack1J3,card2Stack1J4,card2Stack2J1,card2Stack2J2,card2Stack2J3,card2Stack2J4,card2Stack3J1,card2Stack3J2,card2Stack3J3,card2Stack3J4,
    card2Stack4J1,card2Stack4J2,card2Stack4J3,card2Stack4J4,deckOfCards,discardDeck,handCard1,handCard2,handCard3,j1image,j2image,j3image;

    @FXML
    private Circle circleTextPlayer1,circleTextPlayer2,circleTextPlayer3;


    @FXML
    private StackPane stackPane1J1,stackPane1J2,stackPane1J3,stackPane1J4,stackPane2J1,stackPane2J2,stackPane2J3,stackPane2J4
    ,stackPane3J1,stackPane3J2,stackPane3J3,stackPane4J2,stackPane3J4,stackPane4J1,stackPane4J3,stackPane4J4;

    @FXML
    private Text txtJ1,txtJ2,txtJ3;

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

        //System.out.println(manoBot1[0]);

        manoBot1[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        //System.out.println(manoBot1[1]);

        manoBot1[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);

        //System.out.println(manoBot1[2]);

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
        jueganBots(manoBot1, 1);
        jueganBots(manoBot2, 2);
        jueganBots(manoBot3, 3);
    }

    @FXML
    void onc2action(ActionEvent event) {
        buttonAction(1);
        jueganBots(manoBot1, 1);
        jueganBots(manoBot2, 2);
        jueganBots(manoBot3, 3);
    }

    @FXML
    void onc3action(ActionEvent event) {
        buttonAction(2);
        jueganBots(manoBot1, 1);
        jueganBots(manoBot2, 2);
        jueganBots(manoBot3, 3);
    }

    public void checkDeck() {
        if (deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.removeAll(descartes);
            Collections.shuffle(deck.getDeck());
        }
    }

    public void juegatodosBot() {
        checkDeck();
        jueganBots(manoBot1, 1);
        jueganBots(manoBot2, 2);
        jueganBots(manoBot3, 3);
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
    public void jueganBots(Card manoBot[], int bot) {

        if (deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.removeAll(descartes);
            Collections.shuffle(deck.getDeck());
        }

        if (manoBot[0].getType().toString().equals("ORGAN")) {
            juegaOrganBot(0, bot);
            renovarMano(manoBot, 0);

        } else if (manoBot[1].getType().toString().equals("ORGAN")) {
            juegaOrganBot(1, bot);
            renovarMano(manoBot, 1);
        } else if (manoBot[2].getType().toString().equals("ORGAN")) {
            juegaOrganBot(2, bot);
            renovarMano(manoBot, 2);
        } else {
            System.out.println("No habia organo");
            useVirusHealBot();
        }


    }


    public void juegaOrganBot(int aux) {
    	
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
    }

    public void useVirusHealBot() {
    	
        descartes.add(manoBot1[0]);
        renovarMano(manoBot1, 0);
        discardDeck.setImage(manoBot1[0].getImagen());
    }
    public void renovarMano(Card manoX[], int i) {
        manoX[i] = null;
        manoX[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
    }
    public void renovarMiMano(int i) {
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
    public void juegaOrganBot(int aux, int bot) {
        if (bot == 1) {
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
        } else if (bot == 2) {
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
        } else if (bot == 3) {
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

    @FXML
    void onO1j4Action(ActionEvent event) {
        checkDeck();
        useOrgan(RED, stackPane1J4);
        juegatodosBot();
    }

    @FXML
    void onO2j4Action(ActionEvent event) {
        checkDeck();
        useOrgan(BLUE, stackPane2J4);
        juegatodosBot();
    }

    @FXML
    void onO3j4Acton(ActionEvent event) {
        checkDeck();
        useOrgan(GREEN, stackPane3J4);
        juegatodosBot();
    }

    @FXML
    void onO4j4Action(ActionEvent event) {
        checkDeck();
        useOrgan(YELLOW, stackPane4J4);
        juegatodosBot();
    }

    @FXML
    void onO1j1Action(ActionEvent event) {
        useVirus(RED, stackPane1J1);
        juegatodosBot();
    }

    @FXML
    void onO1j2Action(ActionEvent event) {
        useVirus(RED, stackPane1J2);
        juegatodosBot();
    }

    @FXML
    void onO1j3Action(ActionEvent event) {
        useVirus(RED, stackPane1J3);
        juegatodosBot();
    }


    @FXML
    void onO2j2Action(ActionEvent event) {
        useVirus(BLUE, stackPane2J2);
        juegatodosBot();
    }

    @FXML
    void onO2j1Action(ActionEvent event) {
        useVirus(BLUE, stackPane2J1);
        juegatodosBot();
    }

    @FXML
    void onO2j3Action(ActionEvent event) {
        useVirus(BLUE, stackPane2J3);
        juegatodosBot();
    }

    @FXML
    void onO3j1Action(ActionEvent event) {
        useVirus(GREEN, stackPane3J1);
        juegatodosBot();
    }

    @FXML
    void onO3j2Action(ActionEvent event) {
        useVirus(GREEN, stackPane3J2);
        juegatodosBot();
    }

    @FXML
    void onO3j3Action(ActionEvent event) {
        useVirus(GREEN, stackPane3J3);
        juegatodosBot();
    }

    @FXML
    void onO4j1Action(ActionEvent event) {
        useVirus(YELLOW, stackPane4J1);
        juegatodosBot();
    }

    @FXML
    void onO4j2Action(ActionEvent event) {
        useVirus(YELLOW, stackPane4J2);
        juegatodosBot();
    }

    @FXML
    void onO4j3Action(ActionEvent event) {
        useVirus(YELLOW, stackPane4J3);
        juegatodosBot();
    }

    public boolean isOrgan(Card manoX) {
        boolean isOrgan = false;
        if (manoX.getType() == Type.ORGAN)
            isOrgan = true;
        return isOrgan;
    }

    public boolean isColor(Card manoX, Color color) {
        boolean isColor = false;
        if (manoX.getColor() == color)
            isColor = true;
        return isColor;
    }

    public void useVirus(Color color, StackPane stack) {
        Button button = (Button) stack.getChildren().get(0);
        ImageView image = (ImageView) button.getGraphic();
        ImageView imageVirus = (ImageView) stack.getChildren().get(1);
        if (image.getImage() != null) {
            if (mano[0].getColor() == color && mano[0].getType() == Type.VIRUS) {
                imageVirus.setImage(mano[0].getImagen());
                renovarMiMano(0);
            } else if (mano[1].getColor() == color && mano[1].getType() == Type.VIRUS) {
                imageVirus.setImage(mano[1].getImagen());
                renovarMiMano(1);
            } else if (mano[2].getColor() == color && mano[2].getType() == Type.VIRUS) {
                imageVirus.setImage(mano[2].getImagen());
                renovarMiMano(2);
            }
        }
    }

    public void useOrgan(Color color, StackPane stack) {
        Boolean healthy = false;
        Button button = (Button) stack.getChildren().get(0);
        ImageView image = (ImageView) button.getGraphic();
        ImageView imageHeal = (ImageView) stack.getChildren().get(1);
        if (image.getImage() == null) {
            if (mano[0].getColor() == color && mano[0].getType() == Type.ORGAN) {
                image.setImage(mano[0].getImagen());
                renovarMiMano(0);
            } else if (mano[1].getColor() == color && mano[1].getType() == Type.ORGAN) {
                image.setImage(mano[1].getImagen());
                renovarMiMano(1);
            } else if (mano[2].getColor() == color && mano[2].getType() == Type.ORGAN) {
                image.setImage(mano[2].getImagen());
                renovarMiMano(2);
            }
        } else {
            if (imageHeal.getImage() == null && healthy==false) {
                if (mano[0].getColor() == color && mano[0].getType() == Type.HEAL) {
                    imageHeal.setImage(mano[0].getImagen());
                    renovarMiMano(0);
                    healthy = true;
                } else if (mano[1].getColor() == color && mano[1].getType() == Type.HEAL) {
                    imageHeal.setImage(mano[1].getImagen());
                    renovarMiMano(1);
                    healthy = true;
                } else if (mano[2].getColor() == color && mano[2].getType() == Type.HEAL) {
                    imageHeal.setImage(mano[2].getImagen());
                    renovarMiMano(2);
                    healthy = true;
                }
            } else {
                String url = "/image/players/inmune.png";
                if (mano[0].getColor() == color && mano[0].getType() == Type.HEAL) {
                    imageHeal.setImage(new Image(url));
                    renovarMiMano(0);
                } else if (mano[1].getColor() == color && mano[1].getType() == Type.HEAL) {
                    imageHeal.setImage(new Image(url));
                    renovarMiMano(1);
                } else if (mano[2].getColor() == color && mano[2].getType() == Type.HEAL) {
                    imageHeal.setImage(new Image(url));
                    renovarMiMano(2);
                }
            }
        }
    }
}
