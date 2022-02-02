package dad.virus.virus;

public class Organ extends Card{

    private boolean healthy;
    private boolean inmune;
    private int count;

    public Organ(String color, String type) {
        super(color, type);
        this.healthy = true;
        this.inmune = false;
        this.count = 0;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isInmune() {
        return inmune;
    }

    public void setInmune(boolean inmune) {
        this.inmune = inmune;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
