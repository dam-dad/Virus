package dad.virus.game;

public class Card {

	private Color color;
	private Type type;

	public Card(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Card [color=" + color + ", type=" + type + "]";
	}

}
