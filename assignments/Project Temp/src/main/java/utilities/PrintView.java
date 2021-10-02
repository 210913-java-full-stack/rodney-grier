package utilities;


public class PrintView {

    private String s = new String();
    private Double d;
    private int i;

    public int getI() {
        return i;
    }

    public PrintView(Double d, int i) {
        this.d = d;
        this.i = i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public static void printMyView(int i, String item) {

        System.out.println(String.valueOf(item));
    }
    public static void printMyView(String item) {

        System.out.println(String.valueOf(item));
    }


    }

