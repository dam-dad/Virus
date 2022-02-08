package dad.virus;

import dad.virus.game.Card;
import dad.virus.game.Color;
import dad.virus.game.Deck;
import dad.virus.game.Organ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class GameController implements Initializable {


    @FXML
    private ImageView blueImage;

    @FXML
    private Button c1;

    @FXML
    private ImageView greenImate;

    @FXML
    private ImageView handCard1;

    @FXML
    private ImageView handCard2;

    @FXML
    private ImageView handCard3;

    @FXML
    private ImageView redImage;

    @FXML
    private GridPane view;

    @FXML
    private ImageView yellowImage;

    @FXML
    void onClickCard1(MouseEvent event) {

    }


    public GameController() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameView.fxml"));
        loader.setController(this);
        loader.load();

    }

    public GridPane getView() {
        return view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        handCard1.setImage(new Image("/image/players/deck.png"));


    }

    @FXML
    void onc1action(ActionEvent event) {
        Organ card = new Organ(Color.RED);
        Deck deck = new Deck();
        Collections.shuffle(deck.getDeck());
        ArrayList<Card> mano = new ArrayList<>();
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        handCard1.setImage(mano.get(0).getImagen());
        mano.remove(0);
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        System.out.println(deck.getDeck().get(0).getColor() + " " + deck.getDeck().get(0).getType());

        switch (mano.get(0).getColor().toString()){
            case "RED":
                if(redImage.getImage()== null){
                    redImage.setImage(mano.get(0).getImagen());
                }else{
                    handCard3.setImage(mano.get(0).getImagen());
                }
                break;
            case "BLUE":
                if(blueImage.getImage()== null){
                    blueImage.setImage(mano.get(0).getImagen());
                }else{
                    handCard3.setImage(mano.get(0).getImagen());
                }
                break;
            case "GREEN":
                if(greenImate.getImage()== null){
                    greenImate.setImage(mano.get(0).getImagen());
                }else{
                    handCard3.setImage(mano.get(0).getImagen());
                }
                break;
            case "YELLOW":
                if(yellowImage.getImage()== null){
                    yellowImage.setImage(mano.get(0).getImagen());
                }else{
                    handCard3.setImage(mano.get(0).getImagen());
                }
                break;
            default:
                handCard3.setImage(new Image("/image/card/swapBody.png"));
                break;
        }
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
    }

}
