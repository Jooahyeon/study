package array;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        //QA. 2차원 배열에서 변수명.length은 행 or 열 ?
        Scanner sc = new Scanner(System.in);
        System.out.println("학생수를 입력하세요: ");
        int su = sc.nextInt();

        int[][] scores = new int[su][3];
        String[] subjects = {"국어", "영어", "수학"};

        //학생
        for (int i = 0; i < su; i++){            //행?
            System.out.println( (i+1) + "번 학생의 성적을 입력하세요");
            for (int j = 0; j < 3; j++){
                System.out.println(subjects[j] + "점수 :");
                scores[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < su; i++) {
            int total = 0;
            for (int j = 0; j<3; j++) {
                total += scores[i][j];
            }
            double average = total / 3.0;
            System.out.println((i+1) + "번 학생의 총점: " + total + ", 평균" + average);
        }
    }
}
