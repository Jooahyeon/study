package main.java.com.hygge.jungsuk.chap04;

public class Exercise9 {

        public static void main(String[] args) {
            String str = "12345";
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                sum += str.charAt(i);
            }
            System.out.println("sum="+sum);

        }

}
