package demo;

public class AssignmentOprator {
  public static void main(String[] args) {
    int a = 5;
    int b = 10;
    int c = b += a = a -= b / a;
    System.out.println("a: " + a + ", b: " + b + ", c: " + c);
  }
}