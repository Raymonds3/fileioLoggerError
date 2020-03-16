import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void save() {
        try{
            if(!fullname.isEmpty()) {
                File myObj = new File("visitor_" + fullname.toLowerCase().replace(" ", "_") + ".txt");
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(fullname + "\n" + age + "\n"+visitdate.now()+"\n"+visittime.now()+"\n"+comments+"\n"+person_assisted);
                myWriter.close();
                logger.debug("File successful saved");
            }

        } catch (IOException e) {
            logger.error("An error has occured while saving user!");
            e.printStackTrace();
        }
    }

    public static void load(String name) {
        try {
            name = "visitor_" + name.toLowerCase().replace(" ", "_") + ".txt";
//            Scanner myReader = new Scanner(name);
            File myObj = new File(name);
            if (myObj.exists()){
                System.out.println("File name: " + myObj.getName());
                System.out.println("Absolute path: " + myObj.getAbsolutePath());
                System.out.println("Writeable: " + myObj.canWrite());
                System.out.println("Readable " + myObj.canRead());
                System.out.println("File size in bytes " + myObj.length());
            } else {
                System.out.println("The file does not exist.");
            }

//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();

        }catch (Exception e){
            System.out.println("File was not found!");
            e.printStackTrace();
        }
    }

        public static void main(String[] arg) throws IOException {

        Visitor Ryan = new Visitor(
                "Ryan Cooper",30, LocalDate.now(), LocalTime.now(), "this is my comment", "Raymond Serekwane");
        Ryan.save();
        Ryan.load("Ryan Cooper");

    }
}
