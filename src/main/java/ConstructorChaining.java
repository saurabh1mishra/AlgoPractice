public class ConstructorChaining {
    int a, b, c;

    ConstructorChaining() {
        System.out.println("default");
    }

    ConstructorChaining(int a) {
        this();
        this.a = a;
        System.out.println("Constructors a");
    }

    ConstructorChaining(int a, int b) {
        this(a);
        this.b = b;
        System.out.println("Constructors a,b");
    }

    ConstructorChaining(int a, int b, int c) {
        this(a, b);
        this.c = c;
        System.out.println("Constructors a,b,c");
    }


    public static void main(String[] args) {
        ConstructorChaining tets = new ConstructorChaining(1, 2, 3);
    }
}
