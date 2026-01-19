package airamatrix;

public class Test {

    public void m1(ABC a){
        System.out.println("ABC Version");
    }
    public void m1(XYZ m){
        System.out.println("XYZ version");
    }

    static class ABC {

    }

    static class XYZ extends ABC {

    }

    public static void main(String[] args) {
        Test t = new Test();
        ABC a = new ABC();
        t.m1(a);
        XYZ m = new XYZ();
        t.m1(m);
        ABC a1 = new XYZ();
        t.m1(a1);
    }

}
