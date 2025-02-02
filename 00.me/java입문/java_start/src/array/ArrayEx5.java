package array;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력받을 숫자의 개수를 입력하세요: " );
        int num = sc.nextInt();

        int[] count = new int[num];
        int total = 0;
        double average;

        System.out.println(num + "개의 정수를 입력하세요");
        for (int i = 0; i < count.length; i++) {
            count[i] = sc.nextInt();
            total += count[i];
        }
        average = (double)total / count.length;

        //출력
        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + average);

    }
}
