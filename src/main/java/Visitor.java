import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor {
    public static String fullname;
    public static int age;
    public static LocalDate visitdate;
    public static LocalTime visittime;
    public static String comments;
    public static String person_assisted;


    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public Visitor(String fullname, int age, LocalDate visitdate, LocalTime visittime, String comments, String person_assisted) {
        this.fullname = fullname;
        this.age = age;
        this.visitdate = visitdate;
        this.visittime = visittime;
        this.comments = comments;
        this.person_assisted = person_assisted;
    }

    public static void save() throws IOException {
        try {
            if (!fullname.isEmpty()) {
                File myObj = new File("visitor_" + fullname.toLowerCase().replace(" ", "_") + ".txt");
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(fullname + "\n" + age + "\n" + visitdate.now() + "\n" + visittime.now() + "\n" + comments + "\n" + person_assisted);
                myWriter.close();
                logger.info("File successful saved");
            }
        } catch (FileNotFoundException e) {
            logger.error("An error has occured while saving user!");
            e.printStackTrace();
        }
    }

    public static void load(String name) throws IOException {
        try {
            name = "visitor_" + name.toLowerCase().replace(" ", "_") + ".txt";
            File myObj = new File(name);
            if (myObj.exists()) {
                BufferedReader in = new BufferedReader(new FileReader(myObj));
                String line;
                while((line = in.readLine()) != null)
                {
                    logger.info(line);
                }
                in.close();
            }
        } catch (FileNotFoundException e) {
            logger.error("File was not found!");
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) throws IOException {

        Visitor Ryan = new Visitor(
                "Ryan Cooper", 30, LocalDate.now(), LocalTime.now(), "this is my comment", "Raymond Serekwane");
        Ryan.save();
        Ryan.load("Ryan Coope");

        Visitor Bob = new Visitor(
                "Bob Smith", 25, LocalDate.now(), LocalTime.now(), "this is a comment from Bob", "Raymond Serekwane");
        Bob.save();
        Bob.load("Bob Smith");

        Visitor Charlie = new Visitor(
                "Charlie Jones", 28, LocalDate.now(), LocalTime.now(), "this is a comment from Charlie", "Thabo Monamudi");
        Charlie.save();
        Charlie.load("Charlie Jones");
    }
}
