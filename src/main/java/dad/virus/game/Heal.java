package dad.virus.game;

public class Heal extends Card{

    public Heal(Color color) {
        super(color, Type.HEAL);
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
