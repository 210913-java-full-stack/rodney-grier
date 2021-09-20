import models.ToDoItem;
import utility.PrintView;

import java.util.LinkedList;
import java.util.List;

public class main {

    public static void main(String[] args){

        List<ToDoItem> toDoList= new LinkedList<>();

        ToDoItem firstItem = new ToDoItem("Build a to do list");
        toDoList.add(firstItem);

        ToDoItem secondItem = new ToDoItem("Debug the new list");
        toDoList.add(secondItem);

        ToDoItem thirdItem = new ToDoItem("enjoy your list!");
        toDoList.add(thirdItem);

        for (int i = 0; i < toDoList.size(); i++){

            PrintView.printMyView(i + " [" + "] " + toDoList.get(i).getToDoText());


        }

    }
}
