package method;

public class MethodReturn2 {
    public static void main(String[] args) {
        /*설명
         * 사람의 출입을 관리하는 메서드
         * return문을 만나면 그 즉시 해당 메소드를 빠져나간다
         * */
        checkAge(10);
        checkAge(30);

    }

    public static void checkAge(int age){
        if (age < 18) {
            System.out.println(age + "살, 미성년자 출입은 불가능합니다.");
            return;
        }
        System.out.println(age + "살, 입장하세요.");              //반환타입 없는 void라 return생략
    }

}
