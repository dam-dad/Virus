package dad.virus.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

	private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        buildDeck();
    }


    public List<Card> getDeck() {
        return deck;
    }
    
    public Card makeCard(Type type, Color color) {
    	switch (type) {
    	case HEAL: return new Heal(color);
    	case ORGAN: return new Organ(color);
    	//case TREATMENT: return new Treatment(color);
    	case VIRUS: return new Virus(color);
    	default: throw new IllegalArgumentException("Invalid card type");
    	}
    }
    
    private void addToDeck(int count, Type type, Color color) {
    	for (int i = 0; i < count; i++) {
    		deck.add(makeCard(type, color));
    	}
    }

    public void buildDeck() {
    	
    	Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
    		.stream()
    		.forEach(color -> {
    	    	addToDeck(5, Type.ORGAN, color);
    	    	addToDeck(4, Type.VIRUS, color);
    	    	addToDeck(4, Type.HEAL, color);
    		});
    	
    	addToDeck(1, Type.ORGAN, Color.MULTICOLOR);
    	addToDeck(1, Type.VIRUS, Color.MULTICOLOR);
    	addToDeck(4, Type.HEAL, Color.MULTICOLOR);
    	
    	/*addToDeck(2, Type.TREATMENT, Color.MULTICOLOR);
    	addToDeck(3, Type.TREATMENT, Color.RED);
    	addToDeck(3, Type.TREATMENT, Color.GREEN);
    	addToDeck(1, Type.TREATMENT, Color.BLUE);
    	addToDeck(1, Type.TREATMENT, Color.YELLOW);*/

    }
    
}
