package demo;

public class TestHSCPrivateStaticVar {

    public static void main(String[] args) {
        HSCPrivateStaticVar hscPrivateStaticVar = new HSCPrivateStaticVar();
        System.out.println(hscPrivateStaticVar.getTest());
        hscPrivateStaticVar.setTest("testValue");
        System.out.println(hscPrivateStaticVar.getTest());

    }
}
