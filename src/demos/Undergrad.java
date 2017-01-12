package demos;

/**
 * Created by vicente on 1/4/17.
 */
public class Undergrad extends Student1 {
    public void method2(){
        System.out.println("Undergrad 2");
    }

    public static void main(String[] args) {
        People u = new Undergrad();
        u.method1();
        }
}


