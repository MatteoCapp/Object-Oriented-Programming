public class Penalty extends Event {

    private final String whoCommitted;
    private final String reason;
    private final String choice;
    private final boolean isGoalAttempt;

    public Penalty (int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String whoCommitted, String reason, String choice, boolean isGoalAttempt) {

        super(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        this.whoCommitted = whoCommitted;
        this.reason = reason;
        this.choice = choice;
        this.isGoalAttempt = isGoalAttempt;
    }

    public String getWhoCommitted(){
        return this.whoCommitted;
    }

    public String getReason(){
        return this.reason;
    }

    public String getChoice(){
        return this.choice;
    }

    public boolean getIsGoalAttempt(){
        return this.isGoalAttempt;
    }

}