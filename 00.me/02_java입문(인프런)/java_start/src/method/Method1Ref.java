package method;

public class Method1Ref {
        public static void main(String[] args) {
            //중복이 제거되고 코드가 깔끔해짐. (해당 메서드로 이동 ctrl + B)
            //계산1
            int sum1 = add(5,10);                   //메서드 호출
            System.out.println("결과1 출력:" + sum1);
            System.out.println("========================");

            //계산2
            int sum2 = add(10,15);
            System.out.println("결과2 출력:" + sum2);
        }

        //add 메서드 정의
    public static int add (int a, int b) {                  //메서드 선언
        System.out.println(a + "+" + b + " 연산 수행");       //메서드 본문
        int sum = a + b;
        return sum;                                         //실행결과 반환
    }

}

