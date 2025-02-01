package array;

import java.util.Scanner;

public class ArrayEx4 {
    public static void main(String[] args) {
        /*설명
        * 사용자에게 5개의 정수를 입력받아서
        * 이들 정수의 합계와 평균을 계산하는 프로그램을 작성하자.
        * */
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int total = 0;
        double average;

        //입력
        System.out.println("5개의 정수를 입력하시오");
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = sc.nextInt();
            total += numbers[i];
        }
        average = (double)total/numbers.length;

        //출력
        System.out.println("총 합 : "+ total + " 평균 : "+ average);

    }
}
