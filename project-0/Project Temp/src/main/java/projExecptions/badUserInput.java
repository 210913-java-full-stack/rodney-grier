package projExecptions;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

public class badUserInput extends Exception {


    public badUserInput(SQLIntegrityConstraintViolationException f, SQLException g, IOException h, badUserInput i) {

        super("Database Error!");

        try {
            boolean test = true;
            Scanner sc = new Scanner(System.in);
            test = false;
            String input = null;
            String inputT = "1";
            input = inputT;


            System.out.println("Invalid entry, ENTER to Register again");
        } catch (Exception e) {


            String inputE = null;
            String inputT = "1";
            inputE = inputT;

            System.out.println("Invalid entry, ENTER to Register again");

            i.printStackTrace();


        }


    }


}