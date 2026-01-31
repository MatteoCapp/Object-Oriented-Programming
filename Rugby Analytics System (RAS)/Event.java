public class Event {
    private final int halfTime;
    private final int durationSeconds;
    private final String teamInvolved;
    private final double coordX;
    private final double coordY;

    public Event (int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY){
        
        //input sanification
        if (teamInvolved == null || teamInvolved.trim().isEmpty()) {
            throw new IllegalArgumentException("Team involved cannot be empty");
        }

        this.halfTime = halfTime;
        this.durationSeconds = durationSeconds;
        this.teamInvolved = teamInvolved;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    //getter to not break the security and put all in only read mode
    public int getHalfTime(){
        return this.halfTime;
    }

    public int getDurationSeconds(){
        return this.durationSeconds;
    }
    
    public String getTeamInvolved(){
        return this.teamInvolved;
    }

    public double getCoordX(){
        return this.coordX;
    }

    public double getCoordY(){
        return this.coordY;
    }
}