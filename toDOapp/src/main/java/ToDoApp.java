import models.toDOitems;
import utilities.ConnectionManager;
import utilities.PrintView;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ToDoApp {

        public static void main(String[] args){

                //Scanner object bound to System.in, the console input
                Scanner sc = new Scanner(System.in);

                try{
                        Connection conn = ConnectionManager.getConnection();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                 /*List of ToDoItem objects
        Here we create a number of static todoitems and store them into our list. Later we will re-design
        this to be more dynamic and persistent.
        */
        List<toDOitems> toDoList = new LinkedList<>();
        toDOitems newItem1 = new toDOitems();
        newItem1.setMessage("Build a to do list"); //this is the same as doing it with the constructor
        toDoList.add(newItem1);
        toDOitems newItem2 = new toDOitems("Debug the new to do list");
        toDoList.add(newItem2);
        toDOitems newItem3 = new toDOitems("enjoy your new to do list!");
        toDoList.add(newItem3);
        toDOitems newItem4 = new toDOitems("Quit the app!");
        toDoList.add(newItem3);

            //Main app loop
            boolean running = true;
            while(running) {
                System.out.println("===MAIN MENU===\nEnter selection:\n\n1) View ToDo Items.\n2) Mark item complete.\nQ) Quit");
                String input = sc.nextLine();

                switch(input) {
                    case "1":
                        System.out.println("========== To Do List: ==========");
                        for(int i = 0; i < toDoList.size(); i++) {
                            PrintView.printMyView(i, toDoList.get(i));
                        }
                        System.out.println("=================================");
                        break;
                    case "2":
                        //mark item complete method
                        System.out.println("========== To Do List: ==========");
                        for(int i = 0; i < toDoList.size(); i++) {
                            PrintView.printMyView(i, toDoList.get(i));
                        }
                        System.out.print("\nEnter item number to mark complete: ");
                        String choice = sc.nextLine(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
                        toDoList.get(Integer.parseInt(choice)).setComplete(true);

                        System.out.println("\n Item #" + choice + " is complete!");

                        break;
                    case "Q":
                    case "q":
                        running = false;
                        break;
                }
            }


        }

}






