public class Lineout extends Event{

    private final String outcomeLineout;
    private final String thrower;
    private final String howMany;
    private final String jumpPosition;
    private final String isDrive;
    private final String playCall;

    public Lineout (int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String outcomeLineout, String thrower, String howMany, String jumpPosition, String isDrive, String playCall){
        // super method to call event class parameter
        super(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        this.outcomeLineout = outcomeLineout;
        this.thrower = thrower;
        this.howMany = howMany;
        this.jumpPosition = jumpPosition;
        this.isDrive = isDrive;
        this.playCall = playCall;
    }
    
    public String getOutcomeLineout(){
        return this.outcomeLineout;
    }

    public String getThrower(){
        return this.thrower;
    }

    public String getHowMany(){
        return this.howMany;
    }

    public String getJumpPosition(){
        return this.jumpPosition;
    }

    public String getIsDrive(){
        return this.isDrive;
    }

    public String getPlayCall(){
        return this.playCall;
    }
}