package main.java.com.hygge.jungsuk.chap06.objectop;

public class Ex8 {
    class PlayingCard{
        int kind;                       // kind 인스턴스변수
        int num;                        // num 인스턴스변수
        static int width;               // width 클래스변수(static변수, 공유변수)
        static int height;              // height 클래스변수(static변수, 공유변수)
        PlayingCard(int k, int n){      // 메서드영역 -
            kind = k;                   // k 지역변수
            num = n;                    // n 지역변수
        }
        public static void main(String args[]) {            // args 지역변수
//            PlayingCard card = new PlayingCard(1, 1);     // card 지역변수
        }
    }
}
/* 정답 (변수가 선언된 위치를 보면 종류를 알 수 있음)
*   - 클래스 변수(static) : width, height, card (X) =>  width, height
*     (선언위치 : 클래스 영역, 생성시기 : 클래스가 메모리에 올라갈 때)
*
*   - 인스턴스변수 : kind, num (O)
*     (선언위치 : 클래스 영역, 생성시기 : 인스턴스가 생성되었을 때)
*
*   - 지역변수 : k, n (X) => k, n, card, args
*     (선언위치 : 클래스 영역 이외의 영역(메서드, 생성자, 초기화 블럭 내부),
*      생성시기 : 변수 선어눈이 수행되었을 때)
* */