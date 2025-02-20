package ref;

public class Method1 {
    public static void main(String[] args) {
        Student student1 = new Student(); //x001
        initStudent(student1, "학생1", 15, 90);

        Student student2 = new Student(); //x002
        initStudent(student2, "학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);

    }


    private static void initStudent(Student student, String name, int age, int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;

    }

    private static void printStudent(Student student1) {
        System.out.println("이름" + student1.name + "나이:" + student1.age + "성적:" + student1.grade);

    }



}
