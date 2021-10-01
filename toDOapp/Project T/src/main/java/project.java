
import DAOs.dataAccessObj;
import models.getMessages;
import projExecptions.badUserInput;
import utilities.ConnectionManager;
import utilities.PrintView;


import java.io.IOException;
import java.sql.*;
import java.util.*;

public class project {

    public static void main(String[] args) throws SQLException, IOException {

        //Scans for Console input
        Scanner io = new Scanner(System.in);

        //Try to establish connection
        try {
            Connection conn = ConnectionManager.getConnection();

        } catch (SQLException s) {
            s.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //////////////////BANKING APP/////////////////
        boolean running = true;
        boolean custRunning = false;//Test for customer session switch case

        System.out.println("===MAIN MENU===\nPress 'R' to register 'L' to login 'Q' to quit :\n     Register \n     Login \n     Quit");
        String input1 = io.nextLine();

        while (running) {
                        /*
                Switch cases to select options from Start screen. This will include Login, Register
                and Quit
                 */
            switch (input1) {
                //Register for an account
                case "R":
                case "r":
                case "1":

                    boolean test = false;//test for successful registration
                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter First name: ");

                    String fn = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter Middle name: ");

                    String mn = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter Last name: ");
                    String ln = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter email: ");
                    String em = io.nextLine(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter Street: ");
                    String ad = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter city: ");
                    String ci = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter State: ");
                    String st = io.nextLine();

                    System.out.println("========== Register ==========");
                    System.out.print("\nEnter Zipcode: ");
                    String zi = io.nextLine();

                    String bal = "0.00";

            }

            boolean test = true;

            System.out.println("========== Register ==========");

            System.out.print("\nSet new 8 character password: ");

            String pword = io.nextLine().toString(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character

            System.out.println("========== Register ==========");

            System.out.print("\nConfirm password: ");
            String vPword = io.nextLine().toString(); //verify password

            boolean passMatch = (pword.regionMatches(0, vPword, 0, 8));//checks if input strings of password match

            if (passMatch) {

                try {
                    Connection conn = ConnectionManager.getConnection();

                    dataAccessObj dao = new dataAccessObj(conn) {
                        @Override
                        public void addAccount(String s, String e, Double bal) throws SQLException {

                            String email = e;
                            String state = s;

                            String acinsertStatement = "INSERT INTO accounts (account_id, balance) VALUES (\"" + email + state + "\",\"" + bal + "\");";
                            PreparedStatement acpreparedInsertStatement = conn.prepareStatement(acinsertStatement);

                            System.out.println("Registration complete, account added!");


                        }

                    };


                    //Connect to database and get results set for ArrayList

                    ArrayList<getMessages> accountsMenu = new ArrayList<>();
                    ArrayList<getMessages> balanceList = new ArrayList<>();

                    //Sets up menu display and parses data from the above ArrayList
                    getMessages acntNum = new getMessages("======ACCOUNT NUMBER==============");
                    getMessages acntIdN = new getMessages("======ACCOUNTS ID=================");
                    getMessages acntBalC = new getMessages("=======CHECKING==================");
                    accountsMenu.add(acntNum);
                    accountsMenu.add(acntIdN);
                    accountsMenu.add(acntBalC);
                    //Sets up menu display and parses data from the above ArrayList
                    // getMessages newItem1 = new getMessages(rs.getString("account_num"));
                    //  getMessages newItem2 = new getMessages(rs.getString("account_id"));
                    // getMessages newItem3 = new getMessages(rs.getString("balance"));
                    //  balanceList.add(newItem1);
                    //  balanceList.add(newItem2);
                    //  balanceList.add(newItem3);


                    while (custRunning) {


                        String input = io.nextLine();
                            /*
                            This displays a different menu and functions
                             */


                        //New switch case for customer session menu
                        switch (input) {

                            case "1": //View accounts from database/ArrayList
                                System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts \n2) Deposit \n3) Withdrawals/Transfers \nQ) Quit");

                                //Checks account to be viewed and prints each message element
                                // with a header from the accountsMenu ArrayList created above

                                for (int i = 1; i < balanceList.size(); i++) {
                                    PrintView.printMyView(i, accountsMenu.get(i));//Prints Header
                                    PrintView.printMyView(i, balanceList.get(i));//Prints Value
                                }


                                break;

                            case "A":
                            case "a":

                                getMessages newItem4 = new getMessages();
                                newItem4.setMessage("null");
                                balanceList.add(newItem4);

                                getMessages acntBalS = new getMessages();
                                acntBalS.setMessage("=======SAVINGS+===================");
                                accountsMenu.add(acntBalS);


                                boolean test1 = true;

                                while (test1) {


                                    System.out.println("==========ADD ACCOUNT=========");
                                    System.out.print("\nVerify email ");
                                    String e = io.nextLine().toString(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                                    System.out.println("==========ADD ACCOUNT=========");
                                    System.out.print("\nVerify State ");
                                    String s = io.nextLine().toString(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                                    System.out.println("==========ADD ACCOUNT=========");
                                    System.out.print("\nHow much would you like to deposit? ");
                                    String b = io.nextLine().toString(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                                    Double bal = Double.valueOf(b);
                                    System.out.println("==========ADD ACCOUNT==========");
                                    System.out.print("\nVerify 8 character password: ");
                                    System.out.println("==========ADD ACCOUNT=========");
                                    String pword = io.nextLine().toString(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                                    System.out.print("\nConfirm password: ");
                                    String vPword = io.nextLine().toString(); //verify password


//nameList.add(username);//create constructor to input first name to nameList

// List<getMessages> balanceList = new LinkedList<>();
//getMessages loginItem = new getMessages("As a user, I can register for an account. As a user, I can login to my account.");
// menuList.add(loginItem);
//getMessages markItem = new getMessages("As a user, I can deposit funds into my account(s).");
// menuList.add(markItem);
// getMessages registerItem = new getMessages("As a user, I can create one or more bank accounts. As a user, I can withdraw funds from my account(s).");
// menuList.add(registerItem);
// getMessages quitItem = new getMessages("As a user, I can display all of my accounts in a list which includes current balance.");
//   menuList.add(quitItem);
//    System.out.println("========== Login ==========");
//    for(int i = 0; i < menuList.size(); i++) {

//      PrintView.printMyView(i, menuList.get(i));

