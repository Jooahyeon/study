package method;

public class MethodValue2 {
    public static void main(String[] args) {
        int number = 5;
        System.out.println("1. changeNumber 호출 전, num1: " + number);
        changeNumber(number);
        System.out.println("4. changeNumber 호출 후, num1: " + number);
    }
// number값을 복사해서 전달한 것이기에 changeNumber(number)와 int number는 다르다 => 메모리 공간이 다른 곳임
    public static void changeNumber(int number) {
        System.out.println("2. changeNumber 변경 전, num2:" + number);
        number = number * 2;
        System.out.println("3. chageNumber 변경 후, num2: " + number);
    }
}
