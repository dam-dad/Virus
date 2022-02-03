package dad.virus.ui;

import dad.virus.game.Deck;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println(deck.getDeck().remove(50));


    }

}
