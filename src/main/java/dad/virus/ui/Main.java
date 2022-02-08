package dad.virus.ui;

import dad.virus.game.Card;
import dad.virus.game.Deck;
import dad.virus.game.Organ;


import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Collections.shuffle(deck.getDeck());

        ArrayList<Card> mano = new ArrayList<>();

        System.out.println("Cartas en el mazo: "+deck.getDeck().size());
        System.out.println("Asigno mano: ");
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);
        mano.add(deck.getDeck().get(0));
        deck.getDeck().remove(0);

        for(int i=0; i<mano.size();i++){

            System.out.println("Carta: color-> " + mano.get(i).getColor() + " tipo-> "+mano.get(i).getType());
            if(mano.get(i).getType().toString().equals("ORGAN")){
                Organ organ = new Organ(mano.get(i).getColor());
                System.out.println(organ.getType());
                System.out.println("Está sano "+organ.isHealthy());
            }
        }

        System.out.println("Cartas en el mazo: "+deck.getDeck().size());

    }

}
