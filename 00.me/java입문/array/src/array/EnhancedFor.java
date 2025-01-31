package array;

public class EnhancedFor {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        //일반 for문
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }
        //iter (for each문 단축키)
        //향상된 for문, for-each문
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
