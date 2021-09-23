package utilities;

import models.toDOitems;

public class PrintView {

    public static void printMyView(int i, toDOitems item) {
        System.out.print(i + ") [");
        if(item.isComplete()) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
        System.out.println("] " + item.getMessage());
    }

}
