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
	 
	 static Deck deck = new Deck();//Creacion de mazo
	 static Card[] mano ;
	 static ArrayList<Card> descartes ;

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
    private ImageView discard;
    
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
    	
        Collections.shuffle(deck.getDeck());//Baraja de mazo
        mano = new Card[3];//Creacion de mano
        
    	mano[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
        
        mano[1] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
        
        mano[2] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
        
        descartes = new ArrayList<>();
        
        handCard1.setImage(mano[0].getImagen());
        handCard2.setImage(mano[1].getImagen());
        handCard3.setImage(mano[2].getImagen());
    }

    @FXML
    void onc1action(ActionEvent event) {
        
        switch(mano[0].getType().toString()) {
        
        case "ORGAN":
        	useOrgan(0);
        	break;
        case "HEAL":
        	useVirusHeal(0);
        	break;
        case "VIRUS":
        	useVirusHeal(0);
        	break;
        }
    	
        mano[0] = null;
        mano[0] = deck.getDeck().get(0);
        deck.getDeck().remove(0);
        handCard1.setImage(mano[0].getImagen());
        mostrarmano(mano);
        System.out.println("Descartes " + descartes);
        System.out.println("Deck: " + deck.getDeck().size());
        if(deck.getDeck().size() == 0) {
        	deck.getDeck().addAll(descartes);
        	descartes.removeAll(descartes);
        	Collections.shuffle(deck.getDeck());
        }
    }
    
    public void useOrgan(int aux) {
    	mostrarmano(mano);
    	System.out.println(descartes);
    	switch (mano[aux].getColor().toString()){
        case "RED":
            if(redImage.getImage()== null){
                redImage.setImage(mano[aux].getImagen());
            }else{
            	descartes.add(mano[aux]);
            	discard.setImage(mano[aux].getImagen());
            }
            break;
        case "BLUE":
            if(blueImage.getImage()== null){
                blueImage.setImage(mano[aux].getImagen());
            }else{
            	descartes.add(mano[aux]);
            	discard.setImage(mano[aux].getImagen());
            }
            break;
        case "GREEN":
            if(greenImate.getImage()== null){
                greenImate.setImage(mano[aux].getImagen());
            }else{
            	descartes.add(mano[aux]);
            	discard.setImage(mano[aux].getImagen());
            }
            break;
        case "YELLOW":
            if(yellowImage.getImage()== null){
                yellowImage.setImage(mano[aux].getImagen());
            }else{
            	descartes.add(mano[aux]);
            	discard.setImage(mano[aux].getImagen());
            }
            break;
        default:
            discard.setImage(new Image("/image/card/swapBody.png"));
            break;
    }
    }
    
    public void useVirusHeal(int aux) {
    	mostrarmano(mano);
    	
    	descartes.add(mano[aux]);
    	discard.setImage(mano[aux].getImagen());
    }
    
    public void mostrarmano(Card[] mano) {
    	for(int i=0;i<mano.length;i++) {
    		System.out.print(mano[i]);
    	}
    	System.out.println();
    }

}
