public class EventFactory {

    public Event createEvent(int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String outcomeScrum, String outcomeLineout, String type, String kickType,
                            boolean outcomeKick, String playCall, String thrower, String howMany, String jumpPosition, String isDrive, String whoCommitted, String reason, String choice,
                            boolean isGoalAttempt, String description){
        
        if (type == null) type = "DEFAULT";
        
        switch(type){
            
            case "SCRUM":
                return new Scrum(halfTime, durationSeconds, teamInvolved, coordX, coordY, outcomeScrum, playCall);

            case "LINEOUT":
                return new Lineout(halfTime, durationSeconds, teamInvolved, coordX, coordY, outcomeLineout, thrower, howMany,jumpPosition, isDrive, playCall);

            case "KICK":
                return new Kick(halfTime, durationSeconds, teamInvolved, coordX, coordY, kickType, outcomeKick);
            
            case "PENALTY":
                return new Penalty(halfTime, durationSeconds, teamInvolved, coordX, coordY, whoCommitted, reason, choice, isGoalAttempt);

            case "ACTION_GROUP":
                return new ActionGroup(halfTime, durationSeconds, teamInvolved, coordX, coordY, description);

            default:
                return new Event(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        }
    }
}