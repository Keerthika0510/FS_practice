import java.util.Scanner;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int studentId;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void printDetails() {
        System.out.println("name:" + name);
        System.out.println("age:" + age);
        System.out.println("studentid:" + studentId);
    }
}

public class inheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        String name = sc.nextLine();
        int age = sc.nextInt();
        int studentId = sc.nextInt();

        
        Student student = new Student(name, age, studentId);
        student.printDetails();

        sc.close();
    }
}
