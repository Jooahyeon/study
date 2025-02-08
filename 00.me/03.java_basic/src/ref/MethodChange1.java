package ref;

public class MethodChange1 {

    /* 수업목표. 기본형과 메서드 호출 */
    public static void main(String[] args) {
        int a =10;
        System.out.println("메소드 호출 전: " + a);
        changePrimitive(a);
        System.out.println("메소드 호출 후: " + a);
        System.out.println();
    }
    static void changePrimitive(int x) {
        x = 20;
    }

}
