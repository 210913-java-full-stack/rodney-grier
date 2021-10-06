import DAOs.dataAccessObj;
import models.accMsg;
import projExecptions.badPassword;
import projExecptions.badUserInput;
import utilities.ConnectionManager;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import models.arrayList;
import projExecptions.badPassword;

public class project {


    //BANKING PROGRAM MAIN START POINT

    public static void main(String[] args) throws SQLException, IOException, badUserInput {

        //IO AND DB CONNECTIONS
        Connection conn = ConnectionManager.getConnection();
        Scanner sc = new Scanner(System.in);
        boolean custRunning;
        boolean running = true;
        boolean rgstr = true;

        //PERSISTENT TABLE DATA
        arrayList<dataAccessObj, String> balanceList = new arrayList<>(); //keeps the current user account info//updates
        // via the dao object this data persists
        //for the length of the login

        arrayList<dataAccessObj, String> accountsMenu = new arrayList(); //stores the user session information pulled
        //with each option this data pesists only for
        //individual switch cases


        //PASSWORD REPO
        arrayList<Object, Object> pwdAccTable = new arrayList<>();
        String username = "";
        String vPword;
        String pword = "return";
        String fn = "";
        String mn = "";
        String ln = "";
        String ad = "";
        String st = "";
        Integer zi = 0;
        String em = "";
        String c = "";
        String uvPword = "";

        Double bal = 0.00; //stores balance of account being viewed


        //Try to establish a connection
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }


        while (running) {
            //MAIN App
                 /*
                 this constructs the console graphics and displays the list of options. Options are
                 Login, Register and Quit.
                 */

            //TEST TO SEE IF PROGRAM IS RUNNING

            /*                            ///INITIALIZATION SCREEN
             */


            System.out.println("===========================MAIN MENU=======================" +
                    "\n" +
                    "\nREGISTER NOW! and get a FREE interest bearing\n " +
                    "Savings account that earns 30% interest on EVERY\n" +
                    "Transaction LIMITED TIME OFFER OF $200 DEPOSIT WITH NEW ACCOUNTS!" +
                    "\nPress 'R' to register 'L' to login 'Q' to quit :\n     Register \n     Login \n     Quit");

            ///Switch cases to select options from Start screen. This will include Login, Register
            ///and Quit


            String strt = sc.nextLine();


            switch (strt) {


                case "R":
                case "r":

                    while (rgstr) {
                        ///CASE TO REGISTER FOR AN ACCOUNT

                        /////////REGISTRATION

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter First name: ");

                        fn = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Middle name: ");

                        mn = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Last name: ");

                        ln = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter email: ");
                        em = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Street: ");

                        ad = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter city: ");

                        c = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter State: ");
                        st = sc.nextLine();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Zipcode: ");
                        String z = sc.nextLine();
                        zi = Integer.valueOf(z);
                        bal = 200.00;///initial balance can be adjusted here


                        System.out.println("=====Registration Complete==========");
                        username = em + st;///addind these two inputs make up a unique
                        ///combination that will be used as the cust_id
                        /// on the junction_ac table in MariaDb

                        System.out.println("=====Account Added Successfully!==========");

                        boolean login = true;

                        while (login)//////TEST TO SEE IF REGISTRATION HAS
                            //                          BEEN COMPLETE
                            login = false;
                        //this locks the user into this customer_id


                        System.out.println("==========SET NEW PASSWORD==========");
                        System.out.println("\nSet new 8 character password: ");
                        String up = sc.nextLine();//this takes the users email input
                        String upword = up;
                        System.out.println("==========VERIFY PASSWORD ==========");
                        System.out.print("\nConfirm password: ");
                        uvPword = sc.nextLine();//this sets the new 8 digit password
                        System.out.println("== Registration Complete!====");



                        ///this verifies that the user's input matches
                        // boolean passMatch = (upword.regionMatches(0, uvPword, 0, 8));
                        //   if (passMatch) {///THIS PROTECTS THE SECURITY OF THE FIRST TABLE IN
                        //MARIA DB, THE junction_ac TABLE, AND THUS ACHIEVES 1NF FOR THAT TABLE.

                        ///pwdAccTable CLASS BUILDS ANOTHER LAYER OF SECURITY. THIS
                        //IS STORED IN AN ARRAYLIST pwdAccTable, FOR THIS
                        // //USER SESSION AND IS PERSISTED ABOVE IN AN ARRAYLIST
                        pwdAccTable.add(username);
                        pwdAccTable.add(uvPword);///this stores the verified user input for password

                        dataAccessObj dao = new dataAccessObj(conn);

                        //   } else {
                        //  badPassword p = new badPassword();
                        //  p.printStackTrace();
                        //  System.out.println("LOGIN ERROR! PLEASE REGISTER FOR AN ACCOUNT OR TRY YOUR LOGIN AGAIN");


                        //   }

                        dao = new dataAccessObj(conn);
                        dao.saveCustomer(fn, mn, ln, ad, c, st, em, uvPword, zi, bal);

                        break;


                        //ENSURES THAT THE ONLY ACCEPTABLE SELECTION IS "l"


                        ///SWITCH ACCESS
                    }

                case "L":
                case "l":
                    ////MAKE CLASS TO CALL THE JUNCTION_AC TABLE AND LOAD PASSWORD INFO


                    ///Create Login table in DB and add function to call
                    //for username and password set above
                    rgstr = false;

                    String test = "";

                    System.out.println("=====Enter username/email=====");
                    test = sc.nextLine();//this does not push to the arrayList
                    ///unique customer_id string...so it would
                    //                         be "emailst" combined
                    ///as the unique customer_id
                    dataAccessObj dao;
                    dao = new dataAccessObj(conn);
                    username = test;
                    dao.pwdUpdate(username);
                    accMsg tempP = new accMsg();
                    tempP.getItemByID(1);
                    pwdAccTable.setE(tempP);


                    String testVer = "";
                    String testP = "";
                    tempP.setMessage(testVer);
                    System.out.println("========== Password ==========");
                    String userVer = sc.nextLine();

                    userVer = testVer;
                    System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\nA) Accounts (select 'A' to add an account or access current) \n2) Deposit          L) Login to another account \n3) Transfers \nQ) Quit");

                   // /this compares the input to the already
                    //verified user chosen password
                 //   that is persisted in the pwd
//                    boolean passMatch2 = userVer.regionMatches(0, testVer, 0, 8);
//                    if (passMatch2) {
//
//                        pwdAccTable.add(username);
//                       // /this stores the verified user input for password
//
//
//                    } else {
//                        custRunning = false;

                        System.out.println("LOGIN ERROR! PLEASE REGISTER FOR AN ACCOUNT OR TRY YOUR LOGIN AGAIN");


//
                                  break;


                    }  ///WHILE THIS SESSION IS TRUE, SECURITY CAN BE
                    //ASSURED THROUGHOUT THE SESSION///ADDING MORE SECURITY TO THE junction_ac
                    //TABLE IN REGARD TO INTEGRITY
                        custRunning = true;

                    while (custRunning) {

                        rgstr = false;//REGISTRATION IS SET TO FALSE HERE. THAT HAS BEEN COMPLETE
                        custRunning = true;

                        //Sets up the current user session
                        conn = ConnectionManager.getConnection();///THIS CONNECTION WILL PERSIST
                        //THE ENTIRE SESSION AND DOESN'T NEED TO BE RECALLED AT ANY TIME
                        //DURING THE SESSION OF THIS USER. ANY RECONNECTIONS WILL BE
                        //DONE AT THIS POINT  *note this prevents any incomplete information
                        // being sent to the database

// THE saveCustomer CLASS WILL CREATE A DATABASE TABLE IN MARIADB. THIS CORRESPONDS
                        //TO THE junction_ac TABLE AND BASED ON THE INDIVIDUAL accMsg OF
                        //INFORMATION PROVIDED TO THIS CLASS, IT IS ABLE TO PRODUCE
                        // A "NORMALIZED" TABLE TO THIS PROGRAM. THUS, RENDERING
                        // THE FORMAT REUSABLE
                        //FOR ANY FORM OF INFORMATION TO BE STORED IN A "NORMALIZED"
                        // DATABASE SYSTEM...1NF 2NF 3NF.....



                            dataAccessObj dao;
                    //                                          THIS WILL LOOK FOR ANY ADDITIONAL ACCOUNT UPDATES
                    //FOR EXAMPLE, DEPOSIT RESULTS, ACCOUNT UPDATES ETC


                    String input;

                    input = sc.nextLine();
                    switch (input) {
                        //


                        //New switch case for customer session menu. *note (these cases are broken
                        //down into Objects, represented as CLASS's. This allows for
                        ///more flexibility)
                        case "L":
                        case "l":

                            System.out.println("==ACCOUNT MAINTENANCE SWITCH ACCOUNTS===");

                            System.out.println("=====Verify EMAIL of account HOLDER====");
                            System.out.println("Email: " + (em = sc.nextLine()));
                            System.out.println("=====LAST NAME of account HOLDER====");
                            System.out.println("Last name: " + (ln = sc.nextLine()));
                            System.out.println("=====Verify STATE of account HOLDER====");
                            System.out.println("State: " + (st = sc.nextLine()));
                            System.out.println("=====Verify ZIP CODE of account HOLDER====");
                            String z = new String();
                            System.out.println("Zip code: " +(z = sc.nextLine()));
                            zi = Integer.valueOf(z);


                            System.out.println("(Please verify the CUSTOMER ID below and ensure it is correct)");
                            System.out.println("Press ENTER to continue or 1 to cancel");
                            System.out.println("Account Number: " + (em + st));

                            Double dpst = 0.00;
                            accMsg temp;
                            input = sc.nextLine();
                            temp = new accMsg();
                            dao = new dataAccessObj(conn);
                            dao.savePrintLog(em,ln ,st, zi);
                            temp.set(1, dao);
                            balanceList.add(temp);
                            System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit          L) Log into another account \n3) Transfers          (no deposit required when prompted)  \nQ) Quit");




                        case "A":
                        case "a":



                            String b = "";


                            System.out.println("====ACCOUNT MAINTENANCE ADD ACCOUNT=====");
                            System.out.println("Press ENTER to make an initial deposit into the new account");
                            System.out.println("===Amount to deposit====" + (b = sc.nextLine()));
                            System.out.println("$" + (b = sc.nextLine()));
                            //PERSISTENT VARIABLES TO UPDATE ACCOUNTS
                            //LOAD ACCOUNT INFORMATION
                            ////USE THIS TO ADD ADDITIONAL ACCOUNTS

                            dpst = Double.valueOf(b);
                            dao = new dataAccessObj(conn);
                            temp = new accMsg();
                            dao.addNewaccount(fn, ln, zi, em, st, dpst);
                            temp.set(1, dao);
                            balanceList.add(temp);

                            System.out.println("=====Account Added Successfully!==========");


                        case "1":




                            dao = new dataAccessObj(conn);
                            dao.save(em, ln, zi);
                            temp = new accMsg();
                            dao.savePrint(fn, mn, ln, ad, c, st, em, pword, zi, bal);

                            temp.set(1, dao);
                            balanceList.add(temp);


                            dao.savePrintS(fn, mn, ln, ad, c, st, em, pword, zi, bal);
                            //Checks account to be viewed and prints each message element
                            // with info from the accountsMenu arrayList created above.
                            //That information, in turn
                            // was information based on the databaseObj "balanceList"


                            //THIS sets up THE GUI FOR THE ACCOUNT RETRIEVED


                            break;
                        ///PRINT RESULTS


                        case "2":
                        case "D":
                        case "d":

                            ///USE THIS FOR DEPOSITS

                            System.out.println("====ACCOUNT MAINTENANCE DEPOSIT=====");
                            System.out.println("Press ENTER to make a deposit");
                            System.out.println("===Amount to deposit====");
                            System.out.println("$" + (b = sc.nextLine()));
                            dpst = 0.0;         // the next user interaction
                            dpst = Double.valueOf(b);
                            dao = new dataAccessObj(conn);
                            temp = new accMsg();
                            dao.addNewaccount(fn, ln, zi, em, st, dpst);
                            temp.set(1, dao);
                            balanceList.add(temp);

                            System.out.println("=====Account Updated Successfully!======334====");
                            System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit           L) Login to another account\n3) Transfers \nQ) Quit");



                            //Sets up menu display and parses data from the above arrayList


                            break;


                        case "3":
                        case "T":
                        case "t":

                            String w = new String();
                            String st2 = new String();
                            String em2 = new String();


                            System.out.println("====ACCOUNT MAINTENANCE TRANSFERS=====");
                            System.out.println("===Amount to TRANSFER====");
                            System.out.println("$" + (w = sc.nextLine()));
                            System.out.println("=======Enter the EMAIL of the account that will RECEIVE the transfer?====");
                            System.out.println("Recipient State: " + (em2 = sc.nextLine()));
                            System.out.println("=====Verify the ZIPCODE of the RECIPIENT==============");
                            System.out.println("Recipient Zip: " + (z = sc.nextLine()));

                            System.out.println("(Please verify the email of the account owner below and ensure it is correct)");
                            System.out.println("Press ENTER to continue");
                            System.out.println("Account Number: " + (em2 + st2));
                            String inp = "";
                            System.out.println("PRESS ENTER TO CONFIRM. PRESS 1 TO ABORT: " + (inp = sc.nextLine()));
                            input = inp;
                            Double wthdrws = Double.valueOf(w);


                            dao = new dataAccessObj(conn);
                            dao.trnsfrWthd(em, st, em2, st2, wthdrws);
                            balanceList.setE(dao);
                            //Sets up menu display and parses data from the above ArrayList
                            //ADD FOR WITHDRAWALS HERE
                            ////PUT IN dao TO UPDATE ACCOUNT
                            //retrieves previously stored
                            //*build class*                    //information. Only accepts a
                            // Double input wthdrws from user
                            //Sets up menu display and parses data from the above ArrayList
                            //DISPLAY RESULTS
                            //LOOP FOR ADDITIONAL ACCOUNTS
                            System.out.println("=====TRANSFER SUCCESSFUL!==========");
                            System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit           L) Login to another account\n3) Transfers \nQ) Quit");


                            break;


                        case "P":
                        case "p":
                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("======== WHAT ARE YOU UPDATING?=====");
                            System.out.println("1)Last Name\n2)First Name\n3)Address" );
                            String ch = sc.nextLine();
                            Integer choice = Integer.valueOf(ch);


                            ///LOAD ACCOUNT INFORMATION
                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE First name========");
                            System.out.print("\nEnter NEW First name: \n"+ fn);
                            fn = sc.nextLine();

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE middle name=======");
                            System.out.print("\nEnter NEW Middle name: \n"+ mn);
                                    mn = sc.nextLine();

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE Last name=========");
                            System.out.print("\nEnter NEW Last name: \n"+ ln);
                            ln = sc.nextLine();
                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE Address===========");
                            System.out.print("\nEnter NEW Street: " +ad);
                            ad = sc.nextLine();

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE City==============");
                            System.out.print("\nEnter NEW city: "+c);
                            c = sc.nextLine();

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE State=============");
                            System.out.print("\nEnter NEW State: "+st);
                            st = sc.nextLine();

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== UPDATE Zip Code==========");
                            System.out.print("\nEnter NEW Zipcode: \n"+zi);
                            z = sc.nextLine();

                            zi = Integer.valueOf(z);

                            System.out.println("========== UPDATE PROFILE ==========");
                            System.out.println("========== VERIFY EMAIL ONLY========");
                            System.out.print("\nEMAIL:" +em);
                            System.out.print("\nPRESS ENTER");
                            String nun = sc.nextLine();
                            System.out.println("=====Account Updated Successfully!==========");
                            System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit           L) Login to another account\n3) Transfers \nQ) Quit");

                            ///LOAD ACCOUNT INFO
                            //dao.updateProfile CLASS
                            //Checks account to be viewed and prints each message element
                            // with a header from the accountsMenu ArrayList created above
                            ///UPDATE PROFILE
                            dao = new dataAccessObj(conn);

                            temp = new accMsg();
                            dao.savePr(choice, fn, mn, ln, ad, c, st, em, zi);

                            temp.set(1, dao);
                            balanceList.add(temp);
                            System.out.println("=====UPDATE PROFILE COMPLETE==========");


                            break;


                        //QUIT FUNCTION

                        case "Q":
                        case "q":
                            running = false;
                            custRunning = false;

                            break;


                    }

            }


        }


    }
}


































































