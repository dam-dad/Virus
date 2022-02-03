package dad.virus.game;

import java.util.ArrayList;

public class Player {

    private ArrayList<Organ> body;
    private ArrayList<Card> hand;

    public Player() {
        this.body = new ArrayList<>();
        this.hand = new ArrayList<>();
    }

    public ArrayList<Organ> getBody() {
        return body;
    }

    public void setBody(Organ organ) {
        if (this.body == null) {
            this.body.add(organ);
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                if (!this.body.get(i).getColor().equals(organ.getColor())) {
                    this.body.add(organ);
                }
            }
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
