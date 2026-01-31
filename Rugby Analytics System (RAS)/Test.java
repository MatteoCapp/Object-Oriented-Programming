import java.util.logging.*;

public class Test {

    private static final Logger logger = Logger.getLogger(Test.class.getName());
    public static void main(String[] args) {
        //first instance
        Match match = new Match("PVR Rugby", "Soleggiato", "01-01-2026", "25-26", true);
        EventFactory factory = new EventFactory();

        logger.info("Simulazione inserimento dati coach...");

        Event touche = factory.createEvent(1, 10, "Home", 0.0, 45.0, "LINEOUT", "", "Vinta", "", false, "Schema 2", "Ghiretti", "7", "4", "No", "", "", "", false, "");
        match.addEvent(touche);
        
        ActionGroup azioneComplessa = (ActionGroup) factory.createEvent(1, 40, "Home", 50.0, 20.0,"","","ACTION_GROUP","", false, "", "", "", "", "", "", "", "", false,"Mischia dominante con fallo");

        Event mischia = factory.createEvent(1, 20, "Home", 52.0, 22.0, "SCRUM", "Dominante", "", "", false, "8-9 Black", "", "", "", "", "", "", "", false, "");

        Event fallo = factory.createEvent(1, 5, "Away", 52.0, 22.0, "PENALTY", "", "", "", false, "", "", "", "", "", "Away", "Crollo", "Pali", true, "");

        azioneComplessa.addSubEvent(mischia);
        azioneComplessa.addSubEvent(fallo);

        match.addEvent(azioneComplessa);

        // Save
        match.saveResult();

        logger.info("Test terminato");
    }
}