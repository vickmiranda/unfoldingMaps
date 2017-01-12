package demos;

/**
 * Created by vicente on 1/4/17.
 */
public class Student1 extends People {
    public void method1(){
        System.out.println("Student 1");
        //static binding at compiling time
        super.method1();
        //dynamic biding at runtime same as calling this.method2()
        method2();
    }
    public void method2(){
        System.out.println("Student 2");
    }
}
