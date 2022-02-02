package dad.virus.virus;

public class Virus extends Card{

    public Virus(String color, String type) {
        super(color, type = "virus");
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
