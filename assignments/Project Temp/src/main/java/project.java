import com.sun.jdi.DoubleValue;
import models.accMsg;

import models.accMsgInf;
import DAOs.dataAccessObj;

import projExecptions.badUserInput;
import utilities.ConnectionManager;
import utilities.PrintView;
import java.io.IOException;
import java.sql.*;

import java.text.NumberFormat;
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
        arrayList<Object, Object> accountsMenu = new arrayList(); //stores the user session information pulled
        //with each option this data pesists only for
        //individual switch cases


        //PASSWORD REPO
        arrayList<Object, Object> pwdAccTable = new arrayList<>();
        String username;
        String vPword;
        String pword;

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

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter First name: ");
                        String fn;
                        fn = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Middle name: ");
                        String mn;
                        mn = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Last name: ");
                        String ln;
                        ln = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter email: ");
                        String em = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Street: ");
                        String ad;
                        ad = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter city: ");
                        String c;
                        c = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter State: ");
                        String st = sc.toString();

                        System.out.println("========== Register ==========");
                        System.out.print("\nEnter Zipcode: ");
                        String z = sc.nextLine();
                        Integer zi = Integer.valueOf(z);
                        bal = 0.00;///initial balance can be adjusted here


                        System.out.println("=====Registration Complete==========");
                        username = em + st;///addind these two inputs make up a unique
                                                ///combination that will be used as the cust_id
                                                /// on the junction_ac table in MariaDb


                        System.out.println("=====Account Added Successfully!==========");

                        rgstr = false;///this is false because the task has not been complete


                        boolean login = true;

                        while (login)//////TEST TO SEE IF REGISTRATION HAS
                            //                          BEEN COMPLETE

                            login = false;///this locks the user into this customer_id


                        System.out.println("========== Register ==========");
                        System.out.println("\nSet new 8 character password: ");
                        String upword = sc.toString();//this takes the users email input

                        System.out.println("========== Register ==========");
                        System.out.print("\nConfirm password: ");
                        String uvPword = sc.toString();//this sets the new 8 digit password
                        System.out.println("== Registration Complete!====");
                        System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\nA) Add Account \n2) Deposit \n3) Transfers \nQ) Quit");

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
                        //TO PERSIST USER SESSION....USED LATER WITH ANOTHER while CONDITION
                        ///these are not pushed to the arrayList. They are used for verification.
                        pword = "";
                        vPword = "";

                        String lggd = sc.next(("l"));//ENSURES THAT THE ONLY ACCEPTABLE SELECTION IS "l"

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

                                while (pword.regionMatches(0, uvPword, 0, 0)) ;
                                while (email.regionMatches(0, username, 0, 0)) ;


                        }

                        custRunning = true;///WHILE THIS SESSION IS TRUE, SECURITY CAN BE
                        //ASSURED THROUGHOUT THE SESSION///ADDING MORE SECURITY TO THE junction_ac
                        //TABLE IN REGARD TO INTEGRITY


                        while (custRunning) {

                            rgstr = false;//REGISTRATION IS SET TO FALSE HERE. THAT HAS BEEN COMPLETE
                            custRunning = true;


                            passMatch = (pword.regionMatches(0, vPword, 0, 8));//checks if custrunning strings of password match

                                    ///WHILE passMatch is true THE junction_ac TABLE IN MARIADB IS ASSURED
                                    ///TO BE SECURE
                            while (passMatch) {

                                //Sets up the current user session
                                conn = ConnectionManager.getConnection();///THIS CONNECTION WILL PERSIST
                                //THE ENTIRE SESSION AND DOESN'T NEED TO BE RECALLED AT ANY TIME
                                //DURING THE SESSION OF THIS USER. ANY RECONNECTIONS WILL BE
                                //DONE AT THIS POINT  *note this prevents any incomplete information
                                // being sent to the database
                                accMsg newItem1;///gets the initial account info that was set up
                                accMsg newItem2;
                                accMsg newItem3;
                                accMsg newitem4 = new accMsg();

                                ///UPDATES USER SESSION AFTER EACH SWITCH CASE EXITS
                                //AND RETURNS THE INFORMATION TO UPDATE THEIR RELATIONAL DATABASE
                                // IN MARIA DB....accounts_id, customer_id, address_id, and password

                                dataAccessObj dao = new dataAccessObj(conn);
                                dao.saveCustomer(fn, mn, ln, ad, c, st, em, pword, zi, bal);

// THE saveCustomer CLASS WILL CREATE A DATABASE TABLE IN MARIADB. THIS CORRESPONDS
                                //TO THE junction_ac TABLE AND BASED ON THE INDIVIDUAL accMsg OF
                                //INFORMATION PROVIDED TO THIS CLASS, IT IS ABLE TO PRODUCE
                                // A "NORMALIZED" TABLE TO THIS PROGRAM. THUS, RENDERING
                                // THE FORMAT REUSABLE
                                //FOR ANY FORM OF INFORMATION TO BE STORED IN A "NORMALIZED"
                                // DATABASE SYSTEM...1NF 2NF 3NF.....
                                newItem1 = new accMsg();// THIS CLASS IS SPECIFICALLY FOR MESSAGE TRANSFER
                                newItem2 = new accMsg();
                                newItem3 = new accMsg();

               //THIS INTERFACE ALLOWS THE accMsg CLASS TO "getItemByKeyword" AND RETURNS
                                //THE VALUE OF THAT STRING REFERENCE TO accMsg

                                accMsgInf.getItemByKeyword("account_id");
                                accMsgInf.getItemByKeyword("email");
                                accMsgInf.getItemByKeyword("balance");

          //THIS ARRAY LIST NOW STORES AND PERSISTS THE DATA IN accountsMenu FOR THIS SESSION (OR junction_ac for
                                // database reference).
                                //THIS UPDATES THE CURRENT SESSION UNTIL TIME TO SEND THE INFORMATION TO
                                // THE DATABASE

                                accountsMenu.add(newItem1);
                                accountsMenu.add(newItem2);
                                accountsMenu.add(newItem3);

                                //HERE IS WHERE THE accMsgInf INTERFACE ALLOWS THE
                                // accMsg CLASS TO STORE THE
                                //COLLECTED INFORMATION INTO THE ARRAYLIST accountMenu
                                //PERSISTED ABOVE AND PRINTS THE RESULTS TO THE USER
                                //VIA A GUI

                                System.out.println("\n\n===CUSTOMER ACCOUNT MENU===\nEnter selection:\n1) View Accounts (select 'A' to add an account) \n2) Deposit \n3) Transfers \nQ) Quit");

//                                          THIS WILL LOOK FOR ANY ADDITIONAL ACCOUNT UPDATES
                                //FOR EXAMPLE, DEPOSIT RESULTS, ACCOUNT UPDATES ETC

                                accMsgInf.getItemByKeyword("balance");//gets balance from db
                                accountsMenu.add(newitem4);
                                accMsgInf acntBalS = new accMsg();
                                acntBalS.setMessage("=======ACCOUNT MAINTENANCE=================");//Prints GUI
                                accountsMenu.getId(3);
                                System.out.println("=====Account Updated Successfully!==========");

                                break;
                                //New switch case for customer session menu
                            }


                            boolean transfer = false;//NO DEPOSITS OR TRANSFERS REQUESTED
                            boolean deposit = false;




                            String input = sc.nextLine();

                            boolean nwcstmr = true;
                            // /FROM MENU ABOVE
                            while (nwcstmr)

                                nwcstmr = false;///UPDATES TO FALSE RIGHT AWAY
                                            //MAKING THE FORCED SELECTION A ONE TIME THING
                            input = ("a");


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
                                    accMsg newItem1;
                                    accMsg newItem2;
                                    accMsg newItem3;
                                    accMsg newitem4 = new accMsg();


                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);


                                    //Sets up menu display and parses data from the above arrayList


                                    //ADD ACCOUNT INFORMATION HERE

                                    //POSSIBLE TO UPDATED THE INITIAL STARTING BALANCE
                                    // 0.00 bal, if offering
                                    // a signup special

                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);      ///account added to the current session                                   //Prints GUI

                                    System.out.println("=====Account Added Successfully!==========");


                                case "1":


                                    //Checks account to be viewed and prints each message element
                                    // with info from the accountsMenu arrayList created above.
                                    //That information, in turn
                                    // was information based on the databaseObj "balanceList"


                                    //THIS sets up THE GUI FOR THE ACCOUNT RETRIEVED

                                    System.out.println("\n\n\n\n\n\n\n======ACCOUNT NUMBER==============");//Prints GUI
                                    System.out.println(balanceList.getItemByID(0));

                                    System.out.println("======ACCOUNTS ID=================");//Prints GUI
                                    System.out.println(balanceList.getItemByID(1));
                                    //get ACCOUNT # FOR NEXT OPTION
                                    System.out.println("=======CHECKING===================");//Prints GUI
                                    System.out.println(balanceList.getItemByID(2));


                                    accMsgInf.getItemByKeyword("balance");//gets balance for the
                                                                                        //next transaction
                                                                                        //arrayList
                                    balanceList.getItemByKeyword("balance");
                                    accMsg acntBalS = null;
                                    acntBalS.setMessage("=======ACCOUNT MAINTENANCE===========");//Prints GUI
                                    accountsMenu.getId(3);//stores the information above for this user session
                                                                    //in an Array Table(made up of stored
                                    //                                      arrayLists) This is why
                                                                        //it is getting the 3 id to store.


                                    System.out.println("=====Account Added Successfully!==========");

                                    ///PRINT RESULTS

                                    System.out.println("\n\n\n\n\n\n\n======ACCOUNT NUMBER==============");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(1)));//

                                    System.out.println("======ACCOUNTS ID=================");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(2)));

                                    System.out.println("=======CHECKING===================");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(3)));


                                    ////****deposits is initially set to false above so case
                                    //breaks back to switch and updates MariaDb in the process

                                    while (deposit) ;//this will be used for transfers

                                case "2":
                                case "D":
                                case "d":


                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//temp
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);
                                    System.out.println("====ACCOUNT MAINTENANCE=====");
                                    System.out.print("\nEnter Deposit amount:");
                                    System.out.print("$");
                                    Double dpst = sc.nextDouble();


                                    //dao to update account information from previous stored session
                                    //information...no need to request any additional user input and
                                    //thus this helps prevents SQL injection

                                    dataAccessObj dao = new dataAccessObj(conn);
                                    dao.addAccount(st, em, dpst);//ONLY FIELD UPDATED IS THE dpst FIELD
                                    //WHICH ONLY ACCEPTS Double TYPE INPUTS. THE REST ARE STILL STORED FROM BEFORE
                                    // IN THE PERSISTED arrayList.


                                    //ACCOUNT OPTIONS GUI

                                        //PARSES INFORMATION
                                    //FOR THE ACCOUNT THAT THE DEPOSIT IS GOING TO
                                    //

                                    newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//holds balance for stored object
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======SAVINGS+===================");//Prints GUI
                                    accountsMenu.getId(4);
                                    System.out.println("========Enter amount to transfer==========");
                                    System.out.println("$");//will ask for the stored amount on
                                                                // the next user interaction
                                                                        //so the input at that time
                                    //                                              will be the answer
                                                                                //to this question
                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//this gets the current
                                    accMsgInf.getItemByKeyword("email");            //account info
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(String.valueOf(newItem1));//this que's the account for
                                    accountsMenu.add(String.valueOf(newItem2));     ///where the amount goes
                                    accountsMenu.add(String.valueOf(newItem3));
                                    //Sets up menu display and parses data from the above ArrayList

                                    ///TO WHAT ACCOUNT

                                    while (transfer)


                                        newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======SAVINGS+===================");//Prints GUI
                                    accountsMenu.getId(4);
                                    System.out.println("========Enter amount to transfer==========");
                                    System.out.println("$");

                                    //DISPLAY RESULTS
                                    //LOOP FOR ADDITIONAL ACCOUNTS


                                    conn = ConnectionManager.getConnection();
                                    dao.addAccount(st, em, bal);

                                    ///BOOLEAN TO TEST IF CUSTOMER IS MAKING A TRANSFER AND IF SO,
                                    //CONTINUE TO THE SWITCH TO PERSIST THE SECOND ACCOUNT FOR THE SESSION


                                    while (transfer)

                                        ///GETS RESULTS FROM ABOVE arrayList

                                        newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance of where
                                                                                //the transfer is going
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("===How much would you like to transfer?===");//Prints GUI
                                    accountsMenu.getId(0);
                                    System.out.println("$");//will answer this question on the next user interaction



                                                    ///SWITCH FALLS THRU TO
                                                    //THE NEXT PROCESS

                                case "3":
                                case "T":
                                case "t":


                                    deposit = true;
                                    transfer = true;


                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//temp
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);
                                    //Sets up menu display and parses data from the above ArrayList


                                    System.out.println("\n\n\n\n\n\n\n======ACCOUNT NUMBER==============");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(0)));//

                                    System.out.println("======ACCOUNTS ID=================");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(1)));

                                    System.out.println("=====ACCOUNT BALANCE================");//Prints GUI
                                    PrintView.printMyView(String.valueOf(accountsMenu.getId(2)));


                                    newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======ACCOUNT MAINTENANCE==========");//Prints GUI
                                    accountsMenu.getId(0);
                                    System.out.println("=====Account Updated Successfully!==========");


                                    //ADD FOR WITHDRAWALS HERE

                                    Double wthdrws = sc.nextDouble();
                                    ////PUT IN dao TO UPDATE ACCOUNT
                                    dao = new dataAccessObj(conn);
                                    dao.addAccount(0, fn, ln, em, wthdrws);//retrieves previously stored
                                          //*build class*                    //information. Only accepts a
                                                                            // Double input wthdrws from user
                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//temp
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);
                                    //Sets up menu display and parses data from the above ArrayList

                                    System.out.println("=====Account UPDATED Successfully!==========");

                                    ///WHILE deposits = true;
                                    while (deposit)
                                        while (transfer)


                                            //DISPLAY RESULTS
                                            //LOOP FOR ADDITIONAL ACCOUNTS


                                            newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======SAVINGS+===================");//Prints GUI
                                    accountsMenu.getId(4);
                                    System.out.println("=====Account Updated Successfully!==========");


                                    break;


                                case "P":
                                case "p":


                                    ///LOAD ACCOUNT INFORMATION

                                    ///LOAD ACCOUNT INFO
                                                //dao.updateProfile CLASS
                                    //Checks account to be viewed and prints each message element
                                    // with a header from the accountsMenu ArrayList created above


                                    ///UPDATE PROFILE


                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//temp
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);
                                    //Sets up menu display and parses data from the above ArrayList


                                    System.out.println("\n\n\n\n\n\n\n======ACCOUNT NUMBER==============");//Prints GUI
                                    PrintView.printMyView(0, String.valueOf(accountsMenu.getId(0)));//

                                    System.out.println("======ACCOUNTS ID=================");//Prints GUI
                                    PrintView.printMyView(1, String.valueOf(accountsMenu.getId(1)));

                                    System.out.println("=======CHECKING===================");//Prints GUI
                                    PrintView.printMyView(2, String.valueOf(accountsMenu.getId(2)));

                                    //LOOP FOR ADDITIONAL ACCOUNTS


                                    newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======SAVINGS+===================");//Prints GUI
                                    accountsMenu.getId(4);
                                    System.out.println("=====Account Updated Successfully!==========");

                                    //IF - ELSE STATEMENT
                                    //WITHDRAWAL FUNCTION
                                    //DEPOSIT FUNCTION

                                            ///RUN ACCOUNT UPDATE CLASS
                                    //Set up menu display and parses data from the above ArrayList


                                    newItem1 = new accMsg();
                                    newItem2 = new accMsg();
                                    newItem3 = new accMsg();
                                    accMsgInf.getItemByKeyword("account_id");//temp
                                    accMsgInf.getItemByKeyword("email");
                                    accMsgInf.getItemByKeyword("balance");
                                    accountsMenu.add(newItem1);
                                    accountsMenu.add(newItem2);
                                    accountsMenu.add(newItem3);
                                    //Sets up menu display and parses data from the above ArrayList


                                    //DISPLAY RESULTS
                                    //LOOP FOR ADDITIONAL ACCOUNTS


                                    newitem4 = new accMsg();
                                    accMsgInf.getItemByKeyword("balance");//gets balance from db
                                    accountsMenu.add(newitem4);
                                    acntBalS = new accMsg();
                                    acntBalS.setMessage("=======SAVINGS+===================");//Prints GUI
                                    accountsMenu.getId(4);
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



























































