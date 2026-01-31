public class Scrum extends Event{

    private final String outcomeScrum;
    private final String playCall;

    public Scrum (int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String outcomeScrum, String playCall){
        // super method to call event class parameter
        super(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        this.outcomeScrum = outcomeScrum;
        this.playCall = playCall;        
    }
    
    public String getOutcomeScrum(){
        return this.outcomeScrum;
    }

    public String getPlayCall(){
        return this.playCall;
    }
}