import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.*;

public class Match implements Iterable<Event>{ //to make it iterable
    // let's create logger object
    private static final Logger logger = Logger.getLogger(Match.class.getName());
    private final String opponent;
    private final String weather;
    private final String date;
    private final String season;
    private final boolean isHome;
    private final ArrayList<Event> listEvents;

    public Match (String opponent, String weather, String date, String season, boolean isHome){

        //input quality, .trim to take off blank spaces at the start or beginning, is empty to check 
        if(opponent == null || opponent.trim().isEmpty()){
            throw new IllegalArgumentException("Opponent cannot be empty");
        }
        if(weather == null || weather.trim().isEmpty()){
            throw new IllegalArgumentException("Weather cannot be empty");
        }
        if(date == null || date.trim().isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty");
        }
        if(season == null || season.trim().isEmpty()){
            throw new IllegalArgumentException("Season cannot be empty");
        }
        
        this.opponent = opponent;
        this.weather = weather;
        this.date = date;
        this.season = season;
        this.isHome = isHome;

        this.listEvents = new ArrayList<>(); //creat a new empty list
    }


    // iterator method
    @Override
    public Iterator<Event> iterator(){
        return this.listEvents.iterator();
    }

    public void addEvent(Event newEvent){
        this.listEvents.add(newEvent);
    }

    public void saveResult (){

        // name automatically the files, so it will be easier to recognise them
        String homeStatus = this.isHome ? "HOME" : "AWAY";
        String fileName = homeStatus + "_" + this.opponent + "_" + this.season + ".csv";
        
        //cut out the space
        fileName = fileName.replace(" ", "_");

        // logger to be clear more efficient then my logger.info("Trying to save: " + fileName);
        logger.log(Level.INFO, "Trying to save: {0}", fileName);

        // use of LinkedHashSet to mantain order of the column and Set to take column name only once, <String> because header will be only string
        Set<String> extraColumns = new LinkedHashSet<>();

        // iterator pattern to iterate automatically, this is for the Match that has become iteractable
        Iterator<Event> it = this.iterator();

        // while cicle, when is false the game is finished
        while (it.hasNext()){

            Event e = it.next();

            //i need the subclasses viarable into an temporary array
            Field[] fields = e.getClass().getDeclaredFields();

            //for cicle to add the column header
            for (Field f : fields) {

                // i add an if beacuse a do not want a specific column
                if (!f.getName().equals("subEvents")) {
                    extraColumns.add(f.getName());
                }
            }
        }

        //i use file writer methods to close the file no matter what
        try (FileWriter writer = new FileWriter (fileName)){

            logger.info("Saving process started");
            //here to insert user input
            //FileWriter writer = new FileWriter(fileName);
            
            //i will need a CSV so i put here the header
            writer.write("Opponent,Date,Season,Weather,isHome,Half,Team,Seconds,CoordX,CoordY");

            //for each cicle to scroll the set and add every column needed by input in my CSV
            for(String colName : extraColumns){
                writer.write("," + colName);
            }

            writer.write("\n"); // end of line on csv

            //for each event i want the basics information
            for (Event e : listEvents){

                writer.write(this.opponent + "," + this.date + "," + this.season + "," + this.weather + "," + this.isHome + "," + e.getHalfTime() + "," + e.getTeamInvolved()
                            + "," + e.getDurationSeconds() + "," + e.getCoordX() + "," + e.getCoordY());

                //for each to add the info on the column that are not basics
                for (String colName : extraColumns) {

                    try {
                        //i want the name of the field for that class on e for every turn
                        Field f = e.getClass().getDeclaredField(colName);

                        //every variable i set is private for security so i use setAccessible
                        f.setAccessible(true);
                        
                        //now i want to take only the thing inside Event e and write it inside f
                        Object value = f.get(e);
                        writer.write("," + value);
                    
                    //now if the field is empty it is probably a ActionGroup
                    } catch (NoSuchFieldException err) {
                        
                        if (e instanceof ActionGroup){
                            //now java see that is inside, but for it it is still an Event and i need an ActionGroup so i will force it with Casting
                            ActionGroup ag = (ActionGroup) e;

                            //here i want to use a switch, i set a variable false
                            boolean found = false;

                            //now i need a for cicle in every subevent
                            for (Event sub : ag.getSubEvents()){

                                //now i need to understand what is inside here and then switch the found variable on
                                try {

                                    //now i have to ask, what class are you in? have you a column with this name? if true let's put inside a variable its memory address
                                    Field subField = sub.getClass().getDeclaredField(colName);
                                    subField.setAccessible(true); //i need it accessible

                                    writer.write("," + subField.get(sub)); // i writes it thanks to its memory address
                                    
                                    //found switch on
                                    found = true;
                                    break;
                                } catch (NoSuchFieldException | IllegalAccessException subErr) {
                                    // i do not need anything here, just let the cicle go on
                                }
                            }

                            // now if there is no event found it means that this column is not inside of that action so i switch the variable off myself
                            if (!found){
                                writer.write(",None");
                            }
                        } else { // if it was not actiongroup e there was no field i put None
                            writer.write(",None");
                        }
                    } catch (IllegalAccessException err){
                        writer.write(",None"); // you cannot access
                    }
                }

                writer.write("\n"); // end of line on csv
            }

            logger.info("Saved!");

        } catch (IOException e){
            // let's save variable e to check what is wrong
            logger.log(Level.SEVERE, "Error: is not possible create the file ", e);
        }
    }
}