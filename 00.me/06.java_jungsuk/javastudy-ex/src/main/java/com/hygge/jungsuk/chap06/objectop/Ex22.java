package main.java.com.hygge.jungsuk.chap06.objectop;

public class Ex22 {
//    <내 풀이>
//    public static Boolean isNumber(String str) {
//      String str2 = new String();
//      boolean isNumber = false;
//       char ch = ' ';
//
//        for (int i = 0; i < str2.length(); i++) {
//            ch = str2.charAt(i);
//            if (ch >= 48 && ch <= 57) {
//                isNumber = true;
//            } else {
//                isNumber = false;
//            }
//        }
//            return isNumber;
//    }


    //    <정답 풀이>
    public static boolean isNumber(String str) {
        if (str == null || str.equals(""))
            return false;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch < '0' || ch > '9') {
                    return false;

                }
            }
        return true;
    }
    public static void main(String[] args){
        String str="123";
        System.out.println(str + " 는숫자입니까?" + isNumber(str));
        str="1234o";
        System.out.println(str + " 는숫자입니까?" + isNumber(str));
    }

}

/* 설명.
 *   - 메소드(method)란?
 *   어떠한 문제를 처리하기 위한 방법을 소스 코드로 묶어놓고 필요(호출)에 따라 동작하는 기능
 *   - 메소드 선언
 *   public static 리턴 타입(자료형 또는 void)메소드명() {
 *   실행할 코드 작성;
 *   return;
 *   }
 *   - 메소드 리턴타입
 *   메소드의 리턴타입은 자료형(메소드 자료형과 동일한 값) 또는 void(반환 값 없음)
 * */


/* 설명.
*   charAt() : 문자열(String)에서 특정 위치에 있는 문자(char)을 반환
*   - 사용법 :
*   char 문자 = 문자열.charAt(인덱스);
*   - 문자열 길이보다 큰 인덱스를 넣으면 StringIndexOutOfBoundsException 오류 발생
* */