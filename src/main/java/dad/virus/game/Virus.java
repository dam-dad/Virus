package dad.virus.game;

public class Virus extends Card{

    public Virus(Color color) {
        super(color, Type.VIRUS);
    }

    public boolean infect(Organ organ){
        boolean infected = false;
        if(!organ.isInmune() && organ.isHealthy()){
            if(organ.getCount()==1){
                organ.setCount(0);
            }else{
                organ.setHealthy(false);
                infected = true;
            }
        }
        return infected;
    }

}
