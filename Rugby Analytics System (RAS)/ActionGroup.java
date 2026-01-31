// this is the difficult part, i need to connect two separate events in one, i want that penalty could be called even for scrum, lineaout and kicks, i will use the composite pattern
// maybe i will add something more, but it will pass on this node

import java.util.ArrayList;
import java.util.List;

public class ActionGroup extends Event {

    // i need a list for the event that are correlated
    private final List<Event> subEvents;
    private final String description;

    public ActionGroup(int halfTime, int durationSeconds, String teamInvolved, double coordX, double coordY, String description){

        super(halfTime, durationSeconds, teamInvolved, coordX, coordY);
        this.description = description;
        this.subEvents = new ArrayList<>();
    }

    // i will pass an object event, whatever it is, everything is event
    public void addSubEvent(Event e) {
        this.subEvents.add(e); //added to the list
    }

    public List<Event> getSubEvents() {
        return this.subEvents;
    }
    
    public String getDescription() {
        return this.description;
    }
}