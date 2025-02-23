package main.java.com.hygge.jungsuk.chap05.array;

public class Ex4 {
    public static void main(String[] args) {

            int[][] arr = {
                    {5, 5, 5, 5, 5},
                    {10, 10, 10, 10, 10},
                    {20, 20, 20, 20, 20},
                    {30, 30, 30, 30, 30}
            };
            int total = 0;
            float average = 0;

        for (int i = 0; i < arr.length; i++) {         //행
            for (int j = 0; j < arr.length; j++) {
                total += arr[i][j];
            }
            average = total/20f;
        }

            System.out.println("total = " + total);
            System.out.println("average = " + average);
    }//endofmain
}//endofclass
