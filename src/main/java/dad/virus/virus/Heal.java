package dad.virus.virus;

public class Heal extends Card{

    public Heal(String color, String type) {
        super(color, type);
    }

    public void heal(Organ organ){
        if(organ.isHealthy() && organ.getCount() == 1){
            organ.setInmune(true);
        }else{
            organ.setHealthy(true);
            organ.setCount(1);
        }
    }
}
