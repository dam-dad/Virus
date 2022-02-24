package dad.virus;

import dad.virus.game.*;
import dad.virus.reports.ReportPDF;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.*;

import static dad.virus.game.Color.*;
import static dad.virus.game.Type.*;

/**
 * Board controller.
 * Controlador de toda la ventana de juego, incluída su lógica
 */
public class BoardController implements Initializable {

    private static Deck deck = new Deck();//Creacion de mazo
    private static Card[] mano;
    private static Card[] manoBot1;
    private static Card[] manoBot2;
    private static Card[] manoBot3;
    private static Organ[] playerBody;
    private static ArrayList<Card> descartes;
    private static String url = "/image/players/inmune.png";
    private long ini;
    private long end;

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

    private int nTiradas = 0;

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
        
        
        ini = System.currentTimeMillis();
    }

    /**
     * Random number int. Encargado de generar un número aleatorio entre un máximo y un mínimo dados como parámetro
     *
     * @param minimo the minimo
     * @param maximo the maximo
     * @return the int
     */
    public static int randomNumber(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    /**
     * Onc 1 action.
     * Carta izquierda de la mano del jugador. Llama a buttonAction con parámetro 0 y continúa con la acción de los bots
     *
     * @param event the event
     */
    @FXML
    void onc1action(ActionEvent event) {
        buttonAction(0);
        juegatodosBot();
    }

    /**
     * Onc 2 action.
     * Carta central de la mano del jugador. Llama a buttonAction con parámetro 1 y continúa con la acción de los bots
     *
     * @param event the event
     */
    @FXML
    void onc2action(ActionEvent event) {
        buttonAction(1);
        juegatodosBot();
    }

    /**
     * Onc 3 action.
     * Carta derecha de la mano del jugador. Llama a buttonAction con parámetro 2 y continúa con la acción de los bots
     *
     * @param event the event
     */
    @FXML
    void onc3action(ActionEvent event) {
        buttonAction(2);
        juegatodosBot();
    }

    /**
     * On o 1 j 4 action.
     * Donde está situado el lado rojo del cuerpo del jugador
     *
     * @param event the event
     */
    @FXML
    void onO1j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(RED, stackPane1J4))
            juegatodosBot();
    }

    /**
     * On o 2 j 4 action.
     * Donde está situado el lado azul del cuerpo del jugador
     *
     * @param event the event
     */
    @FXML
    void onO2j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(BLUE, stackPane2J4))
            juegatodosBot();
    }

    /**
     * On o 3 j 4 action.
     * Donde está situado el lado verde del cuerpo del jugador
     *
     * @param event the event
     */
    @FXML
    void onO3j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(GREEN, stackPane3J4))
            juegatodosBot();
    }

    /**
     * On o 4 j 4 action.
     * Donde está situado el lado amarillo del cuerpo del jugador
     *
     * @param event the event
     */
    @FXML
    void onO4j4Action(ActionEvent event) {
        checkDeck();
        if (juegaPlayer(YELLOW, stackPane4J4))
            juegatodosBot();
    }

    /**
     * On o 1 j 1 action.
     * Donde está situado el lado rojo del cuerpo del bot 1
     *
     * @param event the event
     */
    @FXML
    void onO1j1Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J1))
            juegatodosBot();
    }

    /**
     * On o 1 j 2 action.
     * Donde está situado el lado rojo del cuerpo del bot 2
     *
     * @param event the event
     */
    @FXML
    void onO1j2Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J2))
            juegatodosBot();
    }

    /**
     * On o 1 j 3 action.
     * Donde está situado el lado rojo del cuerpo del bot 3
     *
     * @param event the event
     */
    @FXML
    void onO1j3Action(ActionEvent event) {
        if (useVirus(RED, stackPane1J3))
            juegatodosBot();
    }


    /**
     * On o 2 j 2 action.
     * Donde está situado el lado azul del cuerpo del bot 2
     *
     * @param event the event
     */
    @FXML
    void onO2j2Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J2))
            juegatodosBot();
    }

    /**
     * On o 2 j 1 action.
     * Donde está situado el lado azul del cuerpo del bot 1
     *
     * @param event the event
     */
    @FXML
    void onO2j1Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J1))
            juegatodosBot();
    }

    /**
     * On o 2 j 3 action.
     * Donde está situado el lado azul del cuerpo del bot 3
     *
     * @param event the event
     */
    @FXML
    void onO2j3Action(ActionEvent event) {
        if (useVirus(BLUE, stackPane2J3))
            juegatodosBot();
    }

    /**
     * On o 3 j 1 action.
     * Donde está situado el lado verde del cuerpo del bot 1
     *
     * @param event the event
     */
    @FXML
    void onO3j1Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J1))
            juegatodosBot();
    }

    /**
     * On o 3 j 2 action.
     * Donde está situado el lado verde del cuerpo del bot 2
     *
     * @param event the event
     */
    @FXML
    void onO3j2Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J2))
            juegatodosBot();
    }

    /**
     * On o 3 j 3 action.
     * Donde está situado el lado verde del cuerpo del bot 3
     *
     * @param event the event
     */
    @FXML
    void onO3j3Action(ActionEvent event) {
        if (useVirus(GREEN, stackPane3J3))
            juegatodosBot();
    }

    /**
     * On o 4 j 1 action.
     * Donde está situado el lado amarillo del cuerpo del bot 1
     *
     * @param event the event
     */
    @FXML
    void onO4j1Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J1))
            juegatodosBot();
    }

    /**
     * On o 4 j 2 action.
     * Donde está situado el lado amarillo del cuerpo del bot 2
     *
     * @param event the event
     */
    @FXML
    void onO4j2Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J2))
            juegatodosBot();
    }

    /**
     * On o 4 j 3 action.
     * Donde está situado el lado amarillo del cuerpo del bot 3
     *
     * @param event the event
     */
    @FXML
    void onO4j3Action(ActionEvent event) {
        if (useVirus(YELLOW, stackPane4J3))
            juegatodosBot();
    }

    /**
     *  METODOS
     **/

    /*  USUARIO  */

    /**
     * Button action.
     * Descarta la carta de la mano del botón seleccionado
     *
     * @param i the
     */
    public void buttonAction(int i) {
        checkDeck();
        descartes.add(mano[i]);
        discardDeck.setImage(descartes.get(0).getImagen());
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
    }//buttonAction

    /**
     * Juega player boolean.
     * Inserta el órgano del color y el stack introducidos por parametro. Si existe órgano, hace lo propio con la cura
     * en caso de tenerla en mano
     *
     * @param color the color
     * @param stack the stack
     * @return the boolean
     */
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
                if ((imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5)) == 'l') {
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
                } else if ((imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5)) == 's') {
                    imageHeal.setImage(null);
                    haJugado = true;
                }
            }

        }
        return haJugado;
    }//juegaPlayer

    /**
     * Use virus boolean.
     * Usa una carta de virus sobre el órgano seleccionado, con condicionales para añadir virus, quitar cura o quitar órgano;
     *
     * @param color the color
     * @param stack the stack
     * @return the boolean
     */
    public boolean useVirus(Color color, StackPane stack) {
        boolean haJugado = false;
        Button button = (Button) stack.getChildren().get(0);
        ImageView image = (ImageView) button.getGraphic();
        ImageView imageVirus = (ImageView) stack.getChildren().get(1);
        if (image.getImage() != null) {
            try {
                if (imageVirus.getImage().getUrl().charAt(imageVirus.getImage().getUrl().length() - 5) == 's') {
                    imageVirus.setImage(null);
                    image.setImage(null);
                    haJugado = true;
                    descartes.add(new Organ(color));
                    descartes.add(new Virus(color));
                    renovarMiMano(getIndex(mano, VIRUS, color));
                } else if (imageVirus.getImage().getUrl().charAt(imageVirus.getImage().getUrl().length() - 5) == 'l') {
                    imageVirus.setImage(null);
                    descartes.add(new Heal(color));
                    renovarMiMano(getIndex(mano, VIRUS, color));
                }
            } catch (NullPointerException e) {
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
    }//useVirus

    /* BOTS */

    /**
     * Juegatodos bot.
     * Comprueba antes de jugar cada bot si el jugador anterior ha ganado
     */
    public void juegatodosBot() {
        checkDeck();
        nTiradas++;
        if (comprobarCuerpo(4)) {
        	
            alertInformation(stage,
                    "Virus",
                    "Tenemos ganador !!",
                    "Felicidades !! Has ganado has vencido al virus.\nTe hacemos entrega del certificado CoVirus en PDF."

            ).showAndWait();
            end = System.currentTimeMillis();

            long totalTime = (end - ini)/1000;

            long seconds = totalTime % 60;
            long minuts = (totalTime % 3600) / 60;
            long hours = totalTime/3600;

            String formatTime = String.format("%02d:%02d:%02d", hours, minuts, seconds);
            ReportPDF reportPDF = new ReportPDF();

            try {
                reportPDF.report(formatTime, nTiradas);
            }catch(Exception ex) {

            }} else {

            Timeline timeline = new Timeline();

            KeyFrame kf1 = new KeyFrame(Duration.seconds(1), e -> {
                juegaBot(manoBot1);
                if (comprobarCuerpo(1)) {
                    timeline.stop();
                    alertInformation(stage,
                            "Virus",
                            " Tenemos ganador !!",
                            " Ha ganado el bot 1."
                    ).showAndWait();
                }
            });
            KeyFrame kf2 = new KeyFrame(Duration.seconds(2), e -> {
                juegaBot(manoBot2);
                if (comprobarCuerpo(2)) {
                    timeline.stop();
                    alertInformation(stage,
                            "Virus",
                            " Tenemos ganador !!",
                            " Ha ganado el bot 2."
                    ).showAndWait();
                }
            });
            KeyFrame kf3 = new KeyFrame(Duration.seconds(3), e -> {
                juegaBot(manoBot3);
                if (comprobarCuerpo(3)) {
                    timeline.stop();
                    alertInformation(stage,
                            "Virus",
                            " Tenemos ganador !!",
                            "Ha ganado el bot 3."
                    ).showAndWait();
                }
            });

            timeline.getKeyFrames().addAll(kf1, kf2, kf3);
            timeline.play();
        }

    }//juegatodosBot

    /**
     * Juega bot boolean.
     * El bot llama a los métodos correspondientes con esta prioridad: intenta usar órgano, si no puede intenta curar órgano,
     * si no puede intenta infectar a un jugador aleatorio, en caso de que no pueda hacer nada de esto, descarta una carta
     * aleatoria
     *
     * @param manoBot the mano bot
     * @return the boolean
     */
    public boolean juegaBot(Card manoBot[]) {
        boolean haJugado = false;
        checkDeck();
        if (manoBot[0].getType() == ORGAN) {
            juegaOrganBot(manoBot, 0);
            renovarMano(manoBot, 0);
            haJugado = true;
        } else if (manoBot[1].getType() == ORGAN) {
            juegaOrganBot(manoBot, 1);
            renovarMano(manoBot, 1);
            haJugado = true;
        } else if (manoBot[2].getType() == ORGAN) {
            juegaOrganBot(manoBot, 2);
            renovarMano(manoBot, 2);
            haJugado = true;
        } else {
            if (!useHealBot(manoBot))
                useVirusBot(manoBot);
        }
        haJugado = true;
        return haJugado;
    }//jueganBots

    /**
     * Juega organ bot.
     * Método para insertar un órgano, pasando por parámetro la mano de cartas del bot correspondiente, un int aux para
     * recorrer la mano en busca de la carta oportuna
     *
     * @param manoBot the mano bot
     * @param aux     the aux
     */
    public boolean juegaOrganBot(Card manoBot[], int aux) {
        boolean haJugado = false;
        ImageView o1 = new ImageView();
        ImageView o2 = new ImageView();
        ImageView o3 = new ImageView();
        ImageView o4 = new ImageView();

        if (manoBot.equals(manoBot1)) {
            o1 = card1Stack1J1;
            o2 = card1Stack2J1;
            o3 = card1Stack3J1;
            o4 = card1Stack4J1;
        } else if (manoBot.equals(manoBot2)) {
            o1 = card1Stack1J2;
            o2 = card1Stack2J2;
            o3 = card1Stack3J2;
            o4 = card1Stack4J2;
        } else if (manoBot.equals(manoBot3)) {
            o1 = card1Stack1J3;
            o2 = card1Stack2J3;
            o3 = card1Stack3J3;
            o4 = card1Stack4J3;
        }
        switch (manoBot[aux].getColor()) {
            case RED:
                if (o1.getImage() == null) {
                    o1.setImage(manoBot[aux].getImagen());
                    haJugado = true;
                }
                break;
            case BLUE:
                if (o2.getImage() == null) {
                    o2.setImage(manoBot[aux].getImagen());
                    haJugado = true;
                }
                break;
            case GREEN:
                if (o3.getImage() == null) {
                    o3.setImage(manoBot[aux].getImagen());
                    haJugado = true;
                }
                break;
            case YELLOW:
                if (o4.getImage() == null) {
                    o4.setImage(manoBot[aux].getImagen());
                    haJugado = true;
                }
                break;
            default:
                discardDeck.setImage(new Image("/image/card/swapBody.png"));
                break;
        }
        return haJugado = true;
    }//juegaOrganBot

    /**
     * Use heal bot boolean.
     * Método que introduce una cura en caso de poder, en función de la mano del bot que se pase por parámetro.
     * Da valor a 4 stackPane auxiliares en función de qué bot juegue. Intentará curar siguiendo la lógica de que si está
     * infectado, retira el virus y la cura, si no lo está, colocará una cura. Si ya tiene cura, lo hace inmune.
     *
     * @param manoBot the mano bot
     * @return the boolean
     */
    public boolean useHealBot(Card manoBot[]) {
        boolean haJugado = false;
        StackPane o1 = new StackPane();
        StackPane o2 = new StackPane();
        StackPane o3 = new StackPane();
        StackPane o4 = new StackPane();
        ImageView temporal = new ImageView();

        if (manoBot.equals(manoBot1)) {
            o1 = stackPane1J1;
            o2 = stackPane2J1;
            o3 = stackPane3J1;
            o4 = stackPane4J1;
        } else if (manoBot.equals(manoBot2)) {
            o1 = stackPane1J2;
            o2 = stackPane2J2;
            o3 = stackPane3J2;
            o4 = stackPane4J2;
        } else if (manoBot.equals(manoBot3)) {
            o1 = stackPane1J3;
            o2 = stackPane2J3;
            o3 = stackPane3J3;
            o4 = stackPane4J3;
        }
        Button button = (Button) o1.getChildren().get(0);
        temporal = (ImageView) button.getGraphic();
        ImageView imageHeal = (ImageView) o1.getChildren().get(1);
        if (temporal.getImage() != null) {
            if (getIndex(manoBot, HEAL, RED) != -1) {
                try {
                    if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 's') {
                        imageHeal.setImage(null);
                        haJugado = true;
                        descartes.add(new Virus(RED));
                        renovarMano(manoBot, getIndex(manoBot, HEAL, RED));
                    } else if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 'l') {
                        imageHeal.setImage(new Image(url));
                        haJugado = true;
                    }
                } catch (NullPointerException e) {
                    imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, RED)].getImagen());
                    haJugado = true;
                }
            } else {
                button = (Button) o2.getChildren().get(0);
                temporal = (ImageView) button.getGraphic();
                imageHeal = (ImageView) o2.getChildren().get(1);
                if (temporal.getImage() != null) {
                    if (getIndex(manoBot, HEAL, BLUE) != -1) {
                        try {
                            if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 's') {
                                imageHeal.setImage(null);
                                haJugado = true;
                                descartes.add(new Virus(BLUE));
                                renovarMano(manoBot, getIndex(manoBot, HEAL, BLUE));
                            } else if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 'l') {
                                imageHeal.setImage(new Image(url));
                                haJugado = true;
                            }
                        } catch (NullPointerException e) {
                            imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, BLUE)].getImagen());
                            haJugado = true;
                        }
                    }
                } else {
                    button = (Button) o3.getChildren().get(0);
                    temporal = (ImageView) button.getGraphic();
                    imageHeal = (ImageView) o3.getChildren().get(1);
                    if (temporal.getImage() != null) {
                        if (getIndex(manoBot, HEAL, GREEN) != -1) {
                            try {
                                if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 's') {
                                    imageHeal.setImage(null);
                                    haJugado = true;
                                    descartes.add(new Virus(GREEN));
                                    renovarMano(manoBot, getIndex(manoBot, HEAL, GREEN));
                                } else if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 'l') {
                                    imageHeal.setImage(new Image(url));
                                    haJugado = true;
                                }
                            } catch (NullPointerException e) {
                                imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, GREEN)].getImagen());
                                haJugado = true;
                            }
                        }
                    } else {
                        button = (Button) o4.getChildren().get(0);
                        temporal = (ImageView) button.getGraphic();
                        imageHeal = (ImageView) o4.getChildren().get(1);
                        if (temporal.getImage() != null) {
                            if (getIndex(manoBot, HEAL, YELLOW) != -1) {
                                try {
                                    if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 's') {
                                        imageHeal.setImage(null);
                                        haJugado = true;
                                        descartes.add(new Virus(YELLOW));
                                        renovarMano(manoBot, getIndex(manoBot, HEAL, YELLOW));
                                    } else if (imageHeal.getImage().getUrl().charAt(imageHeal.getImage().getUrl().length() - 5) == 'l') {
                                        imageHeal.setImage(new Image(url));
                                        haJugado = true;
                                    }
                                } catch (NullPointerException e) {
                                    imageHeal.setImage(manoBot[getIndex(manoBot, HEAL, YELLOW)].getImagen());
                                    haJugado = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return haJugado;
    }//useHealBot

    /**
     * Use virus bot boolean.
     * Método que introduce un virus en caso de poder, en función de la mano del bot que se pase por parámetro.
     * Este condicionará un int descarte que se pasa por parámetro al siguiente método que infecta
     *
     * @param manoBot the mano bot
     * @return the boolean
     */
    public boolean useVirusBot(Card manoBot[]) {
        boolean haJugado = false;
        int descarte;
        if (manoBot.equals(manoBot1)) {
            descarte = 1;
            haJugado = infecta(descarte, manoBot1);
        } else if (manoBot.equals(manoBot2)) {
            descarte = 2;
            haJugado = infecta(descarte, manoBot2);
        } else if (manoBot.equals(manoBot3)) {
            descarte = 3;
            haJugado = infecta(descarte, manoBot3);
        }
        return haJugado;
    }

    /**
     * Método que da valor a 4 StackPAne auxiliares en función de la mano insertada por parámetro. Simulamos aleatoriedad
     * generando un número entre 1 y 4. Si coincide con el jugador que está jugando (param descarte) se descarta de una carta
     * aleatoria. Si no, tratará de infectar al jugador que le tocara, priorizando en este orden los órganos:
     * rojo, azul, verde, amarillo
     *
     * @param descarte
     * @param manoBot
     * @return
     */
    private boolean infecta(int descarte, Card[] manoBot) {
        boolean haJugado = false;
        StackPane o1 = new StackPane();
        StackPane o2 = new StackPane();
        StackPane o3 = new StackPane();
        StackPane o4 = new StackPane();
        int random = randomNumber(1, 4);
        if (random == descarte) {
            useVirusHealBot(manoBot);
        } else {
            switch (random) {
                case 1:
                    o1 = stackPane1J1;
                    o2 = stackPane2J1;
                    o3 = stackPane3J1;
                    o4 = stackPane4J1;
                    break;
                case 2:
                    o1 = stackPane1J2;
                    o2 = stackPane2J2;
                    o3 = stackPane3J2;
                    o4 = stackPane4J2;
                    break;
                case 3:
                    o1 = stackPane1J3;
                    o2 = stackPane2J3;
                    o3 = stackPane3J3;
                    o4 = stackPane4J3;
                    break;
                case 4:
                    o1 = stackPane1J4;
                    o2 = stackPane2J4;
                    o3 = stackPane3J4;
                    o4 = stackPane4J4;
                    break;
            }
            Button button = (Button) o1.getChildren().get(0);
            ImageView imageView = (ImageView) button.getGraphic();
            Button button2 = (Button) o2.getChildren().get(0);
            ImageView imageView2 = (ImageView) button2.getGraphic();
            Button button3 = (Button) o3.getChildren().get(0);
            ImageView imageView3 = (ImageView) button3.getGraphic();
            Button button4 = (Button) o4.getChildren().get(0);
            ImageView imageView4 = (ImageView) button4.getGraphic();
            ImageView inmuneView = new ImageView(new Image(url));

            if (imageView.getImage() != null) {
                ImageView imageVirus = (ImageView) o1.getChildren().get(1);
                try {
                    if (getIndex(manoBot, VIRUS, RED) != -1) {
                        if (!imageVirus.getImage().equals(inmuneView)) {
                            if (imageVirus.getImage().equals(manoBot[getIndex(manoBot, VIRUS, RED)].getImagen())) {
                                imageVirus.setImage(null);
                                imageView.setImage(null);
                                descartes.add(new Organ(RED));
                                descartes.add(new Virus(RED));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, RED));
                                haJugado = true;
                            } else {
                                imageVirus.setImage(null);
                                descartes.add(new Heal(RED));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, RED));
                                haJugado = true;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    imageVirus.setImage(manoBot[getIndex(manoBot, VIRUS, RED)].getImagen());
                    renovarMano(manoBot, getIndex(manoBot, VIRUS, RED));
                    haJugado = true;
                }

            } else if (imageView2.getImage() != null) {
                ImageView imageVirus = (ImageView) o2.getChildren().get(1);
                try {
                    if (getIndex(manoBot, VIRUS, BLUE) != -1) {
                        if (!imageVirus.getImage().equals(inmuneView)) {
                            if (imageVirus.getImage().equals(manoBot[getIndex(manoBot, VIRUS, BLUE)].getImagen())) {
                                imageVirus.setImage(null);
                                imageView.setImage(null);
                                descartes.add(new Organ(BLUE));
                                descartes.add(new Virus(BLUE));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, BLUE));
                                haJugado = true;
                            } else {
                                imageVirus.setImage(null);
                                descartes.add(new Heal(BLUE));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, BLUE));
                                haJugado = true;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    imageVirus.setImage(manoBot[getIndex(manoBot, VIRUS, BLUE)].getImagen());
                    renovarMano(manoBot, getIndex(manoBot, VIRUS, BLUE));
                    haJugado = true;
                }

            } else if (imageView3.getImage() != null) {
                ImageView imageVirus = (ImageView) o3.getChildren().get(1);
                try {
                    if (getIndex(manoBot, VIRUS, GREEN) != -1) {
                        if (!imageVirus.getImage().equals(inmuneView)) {
                            if (imageVirus.getImage().equals(manoBot[getIndex(manoBot, VIRUS, GREEN)].getImagen())) {
                                imageVirus.setImage(null);
                                imageView.setImage(null);
                                descartes.add(new Organ(GREEN));
                                descartes.add(new Virus(GREEN));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, GREEN));
                                haJugado = true;
                            } else {
                                imageVirus.setImage(null);
                                descartes.add(new Heal(GREEN));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, GREEN));
                                haJugado = true;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    imageVirus.setImage(manoBot[getIndex(manoBot, VIRUS, GREEN)].getImagen());
                    renovarMano(manoBot, getIndex(manoBot, VIRUS, GREEN));
                    haJugado = true;
                }

            } else if (imageView4.getImage() != null) {
                ImageView imageVirus = (ImageView) o4.getChildren().get(1);
                try {
                    if (getIndex(manoBot, VIRUS, YELLOW) != -1) {
                        if (!imageVirus.getImage().equals(inmuneView)) {
                            if (imageVirus.getImage().equals(manoBot[getIndex(manoBot, VIRUS, YELLOW)].getImagen())) {
                                imageVirus.setImage(null);
                                imageView.setImage(null);
                                descartes.add(new Organ(YELLOW));
                                descartes.add(new Virus(YELLOW));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, YELLOW));
                                haJugado = true;
                            } else {
                                imageVirus.setImage(null);
                                descartes.add(new Heal(YELLOW));
                                renovarMano(manoBot, getIndex(manoBot, VIRUS, YELLOW));
                                haJugado = true;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    imageVirus.setImage(manoBot[getIndex(manoBot, VIRUS, YELLOW)].getImagen());
                    renovarMano(manoBot, getIndex(manoBot, VIRUS, YELLOW));
                    haJugado = true;
                }

            }
        }
        return haJugado;
    }

    /**
     * Use virus heal bot.
     * Comodín para descartarse un bot en caso de no poder jugar
     *
     * @param manoBot the mano bot
     */
    /* comodin */
    public void useVirusHealBot(Card manoBot[]) {
        descartes.add(manoBot[0]);
        renovarMano(manoBot, 0);
        discardDeck.setImage(descartes.get(0).getImagen());
    }

    /* UTILES */

    /**
     * Check deck.
     * Para comprobar si el deck está vacío, en ese caso cogerá el montón de descartes y lo convierte en el nuevo mazo.
     */
    public void checkDeck() {
        if(descartes.size()!=0){
            discardDeck.setImage(descartes.get(0).getImagen());
            System.out.println(descartes.get(0).getImagen().getUrl()+" cantidad de cartas "+descartes.size());
            System.out.println("---");
        }
        if (deck.getDeck().size() == 0) {
            deck.getDeck().addAll(descartes);
            descartes.clear();
            Collections.shuffle(deck.getDeck());
        }
    }//checkDeck

    /**
     * Gets index.
     * Método que dará la posición de una carta específica que estemos buscando, pasando por parámetro la mano, el tipo
     * de carta y el color de esta
     *
     * @param manoX the mano x
     * @param type  the type
     * @param color the color
     * @return the index
     */
    public int getIndex(Card manoX[], Type type, Color color) {
        int index = -1;
        for (int i = 0; i < manoX.length; i++) {
            if (manoX[i].getType() == type && manoX[i].getColor() == color) {
                index = i;
            }
        }
        return index;
    } //getIndex

    /**
     * Renovar mi mano.
     *
     * @param i the
     */
    public void renovarMiMano(int i) {
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
    }//renovarMiMano

    /**
     * Renovar mano. (del bot)
     *
     * @param manoX the mano x
     * @param i     the
     */
    public void renovarMano(Card manoX[], int i) {
        checkDeck();
        manoX[i] = null;
        manoX[i] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
    }//renovarMano

    /* GANADOR */

    /**
     * Comprueba si tiene todos organos.
     *
     * @param jugador the jugador
     * @return the boolean
     */
    public boolean tieneTodosOrganos(int jugador) {
        boolean tiene = false;
        StackPane o1 = null;
        StackPane o2 = null;
        StackPane o3 = null;
        StackPane o4 = null;
        switch (jugador) {
            case 1:
                o1 = stackPane1J1;
                o2 = stackPane2J1;
                o3 = stackPane3J1;
                o4 = stackPane4J1;
                break;
            case 2:
                o1 = stackPane1J2;
                o2 = stackPane2J2;
                o3 = stackPane3J2;
                o4 = stackPane4J2;
                break;
            case 3:
                o1 = stackPane1J3;
                o2 = stackPane2J3;
                o3 = stackPane3J3;
                o4 = stackPane4J3;
                break;
            case 4:
                o1 = stackPane1J4;
                o2 = stackPane2J4;
                o3 = stackPane3J4;
                o4 = stackPane4J4;
                break;
        }
        Button button = (Button) o1.getChildren().get(0);
        ImageView imageView = (ImageView) button.getGraphic();
        Button button2 = (Button) o2.getChildren().get(0);
        ImageView imageView2 = (ImageView) button2.getGraphic();
        Button button3 = (Button) o3.getChildren().get(0);
        ImageView imageView3 = (ImageView) button3.getGraphic();
        Button button4 = (Button) o4.getChildren().get(0);
        ImageView imageView4 = (ImageView) button4.getGraphic();
        try {
            if (imageView.getImage().getUrl() != null
                    && imageView2.getImage().getUrl() != null
                    && imageView3.getImage().getUrl() != null
                    && imageView4.getImage().getUrl() != null) {
                tiene = true;
            }
        } catch (NullPointerException e) {

        }
        return tiene;
    }

    /**
     * Comprobar cuerpo boolean.
     * Verifica que todos los órganos están sanos (sin carta de virus encima)
     *
     * @param jugador the jugador
     * @return the boolean
     */
    public boolean comprobarCuerpo(int jugador) {
        boolean ganador = false;
        int contador = 0;
        String context;
        if (jugador == 4) {
            context = "¡¡ Felicidades !! Has ganado a estos bots.\nNo olvides recoger tu certificado CoVirus en PDF.";
        } else {
            context = "¡¡ Lástima !!\nHa ganado el jugador " + jugador;
        }

        if (tieneTodosOrganos(jugador)) {
            StackPane o1 = new StackPane();
            StackPane o2 = new StackPane();
            StackPane o3 = new StackPane();
            StackPane o4 = new StackPane();
            switch (jugador) {
                case 1:
                    o1 = stackPane1J1;
                    o2 = stackPane2J1;
                    o3 = stackPane3J1;
                    o4 = stackPane4J1;
                    break;
                case 2:
                    o1 = stackPane1J2;
                    o2 = stackPane2J2;
                    o3 = stackPane3J2;
                    o4 = stackPane4J2;
                    break;
                case 3:
                    o1 = stackPane1J3;
                    o2 = stackPane2J3;
                    o3 = stackPane3J3;
                    o4 = stackPane4J3;
                    break;
                case 4:
                    o1 = stackPane1J4;
                    o2 = stackPane2J4;
                    o3 = stackPane3J4;
                    o4 = stackPane4J4;
                    break;
            }

            try {
                ImageView imageHeal = (ImageView) o1.getChildren().get(1);
                String url1 = imageHeal.getImage().getUrl();
                if (url1.charAt(url1.length() - 5) != 's') {
                    contador++;
                }
            } catch (NullPointerException e) {
                contador++;
            }
            try {
                ImageView imageHeal = (ImageView) o2.getChildren().get(1);
                String url1 = imageHeal.getImage().getUrl();
                if (url1.charAt(url1.length() - 5) != 's') {
                    contador++;
                }
            } catch (NullPointerException e) {
                contador++;
            }
            try {
                ImageView imageHeal = (ImageView) o3.getChildren().get(1);
                String url1 = imageHeal.getImage().getUrl();
                if (url1.charAt(url1.length() - 5) != 's') {
                    contador++;
                }
            } catch (NullPointerException e) {
                contador++;
            }
            try {
                ImageView imageHeal = (ImageView) o4.getChildren().get(1);
                String url1 = imageHeal.getImage().getUrl();
                if (url1.charAt(url1.length() - 5) != 's') {
                    contador++;
                }
            } catch (NullPointerException e) {
                contador++;
            }
            if (contador == 4) {
                ganador = true;
                //alertInformation(stage, "Virus", "¡¡ Tenemos ganador !!", context).showAndWait();
            }
        }
        return ganador;
    }

    /**
     * Alert information alert.
     *
     * @param stage       the stage
     * @param title       the title
     * @param headerText  the header text
     * @param contentText the content text
     * @return the alert
     */
    public Alert alertInformation(Stage stage, String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        
        return alert;
    }
}