package com.ohgirafferse.section04.comparison;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 비교연산자에 대해 이해하고 활용할 수 있다. */
        /* 목차. 1. 숫자값 비교 */
        int iNum1 = 10;
        int iNum2 = 20;
        System.out.println(iNum1 == iNum2);
        System.out.println(iNum1 != iNum2);
        System.out.println(iNum1 >= iNum2);
        System.out.println(iNum1 > iNum2);
        System.out.println(iNum1 <= iNum2);
        System.out.println(iNum1 < iNum2);
        // (me) 왼쪽을 기준으로 읽어랏
        System.out.println();
        System.out.println('a' > 10);       // 문자도 숫자로 취급(유니코드 표 기준)

        /* 목차. 2. 논리값 비교 */
        boolean isNumber1 = true;
        boolean isNumber2 = false;                   // shift + f6  => 더블클릭하고 이름 한번에 바꿀 수 있음
        System.out.println( isNumber1 == isNumber2);
        System.out.println( isNumber1 != isNumber2);
//        System.out.println(isNumber1 >= isNumber2);
//        System.out.println(isNumber1 > isNumber2);
//        System.out.println(isNumber1 <= isNumber2);
//        System.out.println(isNumber1 < isNumber2);

        /* 목차. 3. 문자열값 비교 */
        String str1 = "JAVA";
        String str2 = "JAVA";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);
//        System.out.println(str1 >= str2);
//        System.out.println(str1 > str2);
//        System.out.println(str1 <= str2);
//        System.out.println(str1 < str2);
    }
}
