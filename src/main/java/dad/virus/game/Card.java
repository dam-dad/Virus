package dad.virus.game;

import javafx.scene.image.Image;

public class Card {

	private Color color;
	private Type type;
	private Image imagen;

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

	public void setColor(Color color) {
		this.color = color;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Image getImagen() {
		String color = getColor().toString().toLowerCase();
		String type = getType().toString().toLowerCase();
		imagen = new Image("/image/card/"+ color + type +".png");
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
}
