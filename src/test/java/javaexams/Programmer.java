package javaexams;

abstract class Writer {

    public static void write() {
        System.out.println("Wrtiting");
    }
    public void write2() {
        System.out.println("Wrtiting2");
    }


}

class  Author extends  Writer {
    public static void write() {
        System.out.println("Wrtiting book...");
    }
}

public class Programmer extends Writer {

    public static void write() {
        System.out.println("Wrtiting code");
    }

    public static void main(String[] args) {
        Writer w  = new Programmer();
        Programmer w2 = new Programmer();
        w2.write();
        w.write2();
        w.write();
    }

}
