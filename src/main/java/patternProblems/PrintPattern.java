package patternProblems;

public class PrintPattern {


    public static void printAsc(int lines) {

        for (int i = 0; i < lines; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void printDescTr(int lines) {
        for (int i = 0; i < lines; i++) {
            for (int j = lines - i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void printTriangle(int lines) {
        for (int i = 0; i < lines; i++) {
            for (int j = lines - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        printTriangle(5);
    }
}
