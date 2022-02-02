package dad.virus.Game;

import dad.virus.virus.Card;
import dad.virus.virus.Organ;
import dad.virus.virus.Heal;
import dad.virus.virus.Virus;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int nextCard;

    public Deck() {
        this.deck = new ArrayList<>();
        this.nextCard = 0;
        buildDeck();
    }


    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void buildDeck() {
        deck.add(new Organ("red","organ"));
        deck.add(new Organ("red","organ"));
        deck.add(new Organ("red","organ"));
        deck.add(new Organ("red","organ"));
        deck.add(new Organ("red","organ"));

        deck.add(new Virus("red", "virus"));
        deck.add(new Virus("red", "virus"));
        deck.add(new Virus("red", "virus"));
        deck.add(new Virus("red", "virus"));

        deck.add(new Heal("red", "heal"));
        deck.add(new Heal("red", "heal"));
        deck.add(new Heal("red", "heal"));
        deck.add(new Heal("red", "heal"));

        //blue
        deck.add(new Organ("blue", "organ"));
        deck.add(new Organ("blue", "organ"));
        deck.add(new Organ("blue", "organ"));
        deck.add(new Organ("blue", "organ"));
        deck.add(new Organ("blue", "organ"));

        deck.add(new Virus("blue", "virus"));
        deck.add(new Virus("blue", "virus"));
        deck.add(new Virus("blue", "virus"));
        deck.add(new Virus("blue", "virus"));

        deck.add(new Heal("blue", "heal"));
        deck.add(new Heal("blue", "heal"));
        deck.add(new Heal("blue", "heal"));
        deck.add(new Heal("blue", "heal"));

        //yellow
        deck.add(new Organ("yellow", "organ"));
        deck.add(new Organ("yellow", "organ"));
        deck.add(new Organ("yellow", "organ"));
        deck.add(new Organ("yellow", "organ"));
        deck.add(new Organ("yellow", "organ"));

        deck.add(new Virus("yellow", "virus"));
        deck.add(new Virus("yellow", "virus"));
        deck.add(new Virus("yellow", "virus"));
        deck.add(new Virus("yellow", "virus"));

        deck.add(new Heal("yellow", "heal"));
        deck.add(new Heal("yellow", "heal"));
        deck.add(new Heal("yellow", "heal"));
        deck.add(new Heal("yellow", "heal"));

        //green
        deck.add(new Organ("green", "organ"));
        deck.add(new Organ("green", "organ"));
        deck.add(new Organ("green", "organ"));
        deck.add(new Organ("green", "organ"));
        deck.add(new Organ("green", "organ"));

        deck.add(new Virus("green", "virus"));
        deck.add(new Virus("green", "virus"));
        deck.add(new Virus("green", "virus"));
        deck.add(new Virus("green", "virus"));

        deck.add(new Heal("green", "heal"));
        deck.add(new Heal("green", "heal"));
        deck.add(new Heal("green", "heal"));
        deck.add(new Heal("green", "heal"));

        //multicolor
        deck.add(new Organ("multicolor", "organ"));

        deck.add(new Virus("multicolor", "virus"));

        deck.add(new Heal("multicolor", "heal"));
        deck.add(new Heal("multicolor", "heal"));
        deck.add(new Heal("multicolor", "heal"));
        deck.add(new Heal("multicolor", "heal"));

    }
}
