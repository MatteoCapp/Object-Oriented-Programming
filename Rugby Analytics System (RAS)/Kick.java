public class Kick extends Event {

    private final String kickType;
    private final boolean outcomeKick;

    public Kick (int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String kickType, boolean outcomeKick){

        super(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        this.kickType=kickType;
        this.outcomeKick=outcomeKick;
    }

    public boolean getOutcomeKick(){
        return this.outcomeKick;
    }    

    public String getKickType(){
        return this.kickType;
    }       
}