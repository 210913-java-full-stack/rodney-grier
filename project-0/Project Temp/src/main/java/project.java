import DAOs.dataAccessObj;
import projExecptions.badUserInput;
import utilities.ConnectionManager;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import models.arrayList;


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
        dataAccessObj balanceList = new dataAccessObj(conn); //keeps the current user account info//updates
        // via the dao object this data persists
        //for the length of the login

        arrayList<dataAccessObj,String> accountsMenu = new arrayList(); //stores the user session information pulled
        //with each option this data pesists only for
        //individual switch cases


        //PASSWORD REPO
        arrayList<Object, Object> pwdAccTable = new arrayList<>();
        String username;
        String vPword;
        String pword = "return";

        Double bal; //stores balance of account being viewed


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


            System.out.println("===MAIN MENU===\nPress 'R' to register 'L' to login 'Q' to quit :\n     Register \n     Login \n     Quit");

            ///Switch cases to select options from Start screen. This will include Login, Register
            ///and Quit


            String strt = sc.nextLine();


            switch (strt) {


                case "R":
                case "r":

                    while (rgstr) {
                        ///CASE TO REGISTER FOR AN ACCOUNT

                        /////////REGISTRATION

                        System.out.println("========== Register1 ==========");
                        System.out.print("\nEnter First name: ");
                        String fn = "";
                        fn = sc.nextLine();

                        System.out.println("========== Register2 ==========");
                        System.out.print("\nEnter Middle name: ");
                        String mn;
                        mn = sc.nextLine();

                        System.out.println("========== Register4 ==========");
                        System.out.print("\nEnter Last name: ");
                        String ln;
                        ln = sc.nextLine();

                        System.out.println("========== Register5 ==========");
                        System.out.print("\nEnter email: ");
                        String em = sc.nextLine();

                        System.out.println("========== Register6 ==========");
                        System.out.print("\nEnter Street: ");
                        String ad;
                        ad = sc.nextLine();

                        System.out.println("========== Register7 ==========");
                        System.out.print("\nEnter city: ");
                        String c;
                        c = sc.nextLine();

                        System.out.println("========== Register8 ==========");
                        System.out.print("\nEnter State: ");
                        String st = sc.nextLine();

                        System.out.println("========== Register9 ==========");
                        System.out.print("\nEnter Zipcode: ");
                        String z = sc.nextLine();
                        Integer zi = Integer.valueOf(z);
                        bal = 200.00;///initial balance can be adjusted here


                        System.out.println("=====Registration Complete==========");
                        username = em + st;///addind these two inputs make up a unique
                        ///combination that will be used as the cust_id
                        /// on the junction_ac table in MariaDb


                        System.out.println("=====Account Added Successfully!=====142=====");


                        boolean login = true;

                        while (login)//////TEST TO SEE IF REGISTRATION HAS
                            //                          BEEN COMPLETE

                            login = false;///this locks the user into this customer_id


                        System.out.println("==========SET NEW PASSWORD==========");
                        System.out.println("\nSet new 8 character password: ");
                        String upword = sc.nextLine();//this takes the users email input

                        System.out.println("==========VERIFY PASSWORD ==========");
                        System.out.print("\nConfirm password: ");
                        String uvPword = sc.nextLine();//this sets the new 8 digit password
                        System.out.println("== Registration Complete!====");

                        ///this verifies that the user's input matches
                        boolean passMatch = (upword.regionMatches(0, uvPword, 0, 8));
                        if (passMatch) {///THIS PROTECTS THE SECURITY OF THE FIRST TABLE IN
                            //MARIA DB, THE junction_ac TABLE, AND THUS ACHIEVES 1NF FOR THAT TABLE.

                            ///pwdAccTable CLASS BUILDS ANOTHER LAYER OF SECURITY. THIS
                            //IS STORED IN AN ARRAYLIST pwdAccTable, FOR THIS
                            // //USER SESSION AND IS PERSISTED ABOVE IN AN ARRAYLIST
                            pwdAccTable.add(username);
                            pwdAccTable.add(uvPword);///this stores the verified user input for password


                        }


                        //ENSURES THAT THE ONLY ACCEPTABLE SELECTION IS "l"
                        while (rgstr)

                            rgstr = false;
                        String lggd = new String();
                        switch (lggd) {///SWITCH ACCESS


                            case "L":
                            case "l":

                                ///Create Login table in DB and add function to call
                                //for username and password set above


                                System.out.println("=====Enter username/email=====");
                                String email = sc.nextLine();//this does not push to the arrayList
                                System.out.println("======== Confirm State=====");
                                uvPword = sc.nextLine();///this is to comlete the second half of the
                                ///unique customer_id string...so it would
                                //                                  be "emailst" combined
                                ///as the unique customer_id

                                System.out.println("========== Password ==========");
                                pword = sc.nextLine();
                                ///this compares the input to the already
                                ////verified user chosen password
                                //that is persisted in the pwd

                                while (pword.regionMatches(0, uvPword, 0, 8)) ;
                                while (email.regionMatches(0, username, 0, 8)) ;


                        }

                        custRunning = true;///WHILE THIS SESSION IS TRUE, SECURITY CAN BE
                        //ASSURED THROUGHOUT THE SESSION///ADDING MORE SECURITY TO THE junction_ac
                        //TABLE IN REGARD TO INTEGRITY
                        dataAccessObj dao = new dataAccessObj(conn);
                        dao.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, bal);

                        while (custRunning) {

                            rgstr = false;//REGISTRATION IS SET TO FALSE HERE. THAT HAS BEEN COMPLETE
                            custRunning = true;

                            passMatch = (upword.regionMatches(0, uvPword, 0, 8));
                            if (passMatch) {///THIS PROTECTS THE SECURITY OF THE FIRST TABLE IN
                                //MARIA DB, THE junction_ac TABLE, AND THUS ACHIEVES 1NF FOR THAT TABLE.

                                ///pwdAccTable CLASS BUILDS ANOTHER LAYER OF SECURITY. THIS
                                //IS STORED IN AN ARRAYLIST pwdAccTable, FOR THIS
                                // //USER SESSION AND IS PERSISTED ABOVE IN AN ARRAYLIST
                                pwdAccTable.add(username);
                                pwdAccTable.add(uvPword);///this stores the verified user input for password

                                //Sets up the current user session
                                conn = ConnectionManager.getConnection();///THIS CONNECTION WILL PERSIST
                                //THE ENTIRE SESSION AND DOESN'T NEED TO BE RECALLED AT ANY TIME
                                //DURING THE SESSION OF THIS USER. ANY RECONNECTIONS WILL BE
                                //DONE AT THIS POINT  *note this prevents any incomplete information
                                // being sent to the database


                                ///UPDATES USER SESSION AFTER EACH SWITCH CASE EXITS
                                //AND RETURNS THE INFORMATION TO UPDATE THEIR RELATIONAL DATABASE
                                // IN MARIA DB....accounts_id, customer_id, address_id, and password

       ///MAKE THIS REFRESH ACCOUNT lIST
                                dao = new dataAccessObj(conn);
                                balanceList.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, bal);


// THE saveCustomer CLASS WILL CREATE A DATABASE TABLE IN MARIADB. THIS CORRESPONDS
                                //TO THE junction_ac TABLE AND BASED ON THE INDIVIDUAL accMsg OF
                                //INFORMATION PROVIDED TO THIS CLASS, IT IS ABLE TO PRODUCE
                                // A "NORMALIZED" TABLE TO THIS PROGRAM. THUS, RENDERING
                                // THE FORMAT REUSABLE
                                //FOR ANY FORM OF INFORMATION TO BE STORED IN A "NORMALIZED"
                                // DATABASE SYSTEM...1NF 2NF 3NF.....


                                //THIS INTERFACE ALLOWS THE accMsg CLASS TO "getItemByKeyword" AND RETURNS
                                //THE VALUE OF THAT STRING REFERENCE TO accMsg


                                //THIS ARRAY LIST NOW STORES AND PERSISTS THE DATA IN accountsMenu FOR THIS SESSION (OR junction_ac for
                                // database reference).
                                //THIS UPDATES THE CURRENT SESSION UNTIL TIME TO SEND THE INFORMATION TO
                                // THE DATABASE


                                //HERE IS WHERE THE accMsgInf INTERFACE ALLOWS THE
                                // accMsg CLASS TO STORE THE
                                //COLLECTED INFORMATION INTO THE ARRAYLIST accountMenu
                                //PERSISTED ABOVE AND PRINTS THE RESULTS TO THE USER
                                //VIA A GUI

                                System.out.println("\n\n===CUSTOMER ACCOUNT MENU=285==\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit \n3) Transfers \nQ) Quit");
                            }

                            //                                          THIS WILL LOOK FOR ANY ADDITIONAL ACCOUNT UPDATES
                            //FOR EXAMPLE, DEPOSIT RESULTS, ACCOUNT UPDATES ETC


                            //New switch case for customer session menu


                            String input;

                            input = sc.nextLine();
                            switch (input) {
                                //


                                //New switch case for customer session menu. *note (these cases are broken
                                //down into Objects, represented as CLASS's. This allows for
                                ///more flexibility)

                                case "A":
                                case "a":

                                    //THIS PROCESS IS AUTOMATIC ONCE THE CASE IS
                                    //SELECTED AND IMMEDIATELY "FALLS THRU" TO THE
                                    //MAIN MENU

                                    //PERSISTENT VARIABLES TO UPDATE ACCOUNTS
                                    //LOAD ACCOUNT INFORMATION
                       ////USE THIS TO ADD ADDITIONAL ACCOUNTS
                                    String b = "";


                                    System.out.println("====ACCOUNT MAINTENANCE ADD ACCOUNT=====");
                                    System.out.println("===Account Balance==== $" +bal);
                                    System.out.println("===Amount to deposit====$" +(b = sc.nextLine()));

                                    Double dpst = 0.0;         // the next user interaction
                                    dpst = Double.valueOf(b);

                                    balanceList.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, dpst);

                                    System.out.println("=====Account Added Successfully!======334====");



                                //Sets up menu display and parses data from the above arrayList


                                //ADD ACCOUNT INFORMATION HERE

                                //POSSIBLE TO UPDATED THE INITIAL STARTING BALANCE
                                // 0.00 bal, if offering
                                // a signup special


                                case "1":



                                    balanceList.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, bal);

                                    //Checks account to be viewed and prints each message element
                                    // with info from the accountsMenu arrayList created above.
                                    //That information, in turn
                                    // was information based on the databaseObj "balanceList"


                                    //THIS sets up THE GUI FOR THE ACCOUNT RETRIEVED

                                    System.out.println("=====Account Update Successful====380======");
                                        break;
                                    ///PRINT RESULTS





                                case "2":
                                case "D":
                                case "d":


                                    System.out.println("====ACCOUNT MAINTENANCE DEPOSITS=====");
                                    System.out.println("===Account Balance==== $" +bal);
                                    System.out.println("===Amount to deposit====");
                                    System.out.println("$"+(b = sc.nextLine()));
                                    System.out.println("=====Which account would you like to deposit into====");
                                    System.out.println("(Please verify Account number below:");
                                    String choice = sc.nextLine();
                                    dpst = Double.valueOf(b);//so the input at that time

                                    //to this question
                            ///USE THIS FOR DEPOSITS

                                    balanceList.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, dpst);

                                    //dao to update account information from previous stored session
                                    //information...no need to request any additional user input and
                                    //thus this helps prevents SQL injection


                                    //WHICH ONLY ACCEPTS Double TYPE INPUTS. THE REST ARE STILL STORED FROM BEFORE
                                    // IN THE PERSISTED arrayList.

                                    //ACCOUNT OPTIONS GUI
                                    //PARSES INFORMATION
                                    //FOR THE ACCOUNT THAT THE DEPOSIT IS GOING TO
                                    //


                                    //DISPLAY RESULTS
                                    //LOOP FOR ADDITIONAL ACCOUNTS




                                    ///BOOLEAN TO TEST IF CUSTOMER IS MAKING A TRANSFER AND IF SO,
                                    //CONTINUE TO THE SWITCH TO PERSIST THE SECOND ACCOUNT FOR THE SESSION




                                        ///GETS RESULTS FROM ABOVE arrayList

                                        break;
                                    //the transfer is going


                                    ///SWITCH FALLS THRU TO
                                    //THE NEXT PROCESS

                                case "3":
                                case "T":
                                case "t":

                                    System.out.println("=======Which account will recieve the transfer?====");
                                    String choice2 = sc.nextLine();
                                    System.out.println("=====How would you like to transfer?====535=" +
                                            "==");
                                    Double wthdrws = sc.nextDouble();

                                    conn = ConnectionManager.getConnection();
                                    balanceList.addAccount(1, fn, ln, em, wthdrws);///this executes the withdrawal for the transaction

                                    //Sets up menu display and parses data from the above ArrayList
                                    //ADD FOR WITHDRAWALS HERE
                                    ////PUT IN dao TO UPDATE ACCOUNT
                                    //retrieves previously stored
                                    //*build class*                    //information. Only accepts a
                                    // Double input wthdrws from user
                                    //Sets up menu display and parses data from the above ArrayList
                                    //DISPLAY RESULTS
                                    //LOOP FOR ADDITIONAL ACCOUNTS
                                     System.out.println("=====TRANSFER SUCCESSFUL!======574====");


                                    break;


                                case "P":
                                case "p":


                                    ///LOAD ACCOUNT INFORMATION
                                    ///LOAD ACCOUNT INFO
                                    //dao.updateProfile CLASS
                                    //Checks account to be viewed and prints each message element
                                    // with a header from the accountsMenu ArrayList created above
                                    ///UPDATE PROFILE
                                    //LOOP FOR ADDITIONAL ACCOUNTS
                                    //IF - ELSE STATEMENT
                                    //WITHDRAWAL FUNCTION
                                    //DEPOSIT FUNCTION
                                    ///RUN ACCOUNT UPDATE CLASS
                                    //Set up menu display and parses data from the above ArrayList
                                    //Sets up menu display and parses data from the above ArrayList
                                    //DISPLAY RESULTS
                                    //LOOP FOR ADDITIONAL ACCOUNTS
                                    System.out.println("=====Account Updated Successfully!==========");
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
    }
}































































