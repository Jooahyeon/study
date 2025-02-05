package com.ohgiraffers.section02.string;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. String 클래스의 자주 사용하는 메소드에 대해 이해할 수 있다. */
        /* 목차. 1. charAt()*/
        //char ch = sc.nextLine().charAt(0);            sc.nextLine() = new String("홍") -> 둘다 힙 영역에 생김
        //ㅁ

        String str1 = "apple";

        for (int i = 0; i < str1.length(); i++) {
            System.out.println("charAt(" + i + ") = " + str1.charAt(i));
        }

        /* 목차. 2. compareTo()_맨앞자리로 서로 얼마나 떨어져 있는지를 출력 */
        String str2 = "java";
        String str3 = "java";
        String str4 = "JAVA";
        String str5 = "mariaDB";
        System.out.println(str2.compareTo(str3));
        //.compareTo 는 반환형이 int (음수와 양수가 나옴 => 나중에 정렬할 때 사용)

        int j = 'j';
        int J = 'J';
        System.out.println("j = " + j + ", J = " + J);
        System.out.println(str2.compareTo(str4));
        System.out.println(str4.compareTo(str2));
        System.out.println(str2.compareTo(str5));
        System.out.println(str5.compareTo(str2));

        /* 목차. 3. concat() */
        System.out.println("concat(): " + str2.concat(str5));

        /* 목차. 4. indexOf() _ 문자 위치를 찾아주는 것 */
        String indexOf = "java mariaDB";
        System.out.println("indexOf('a'): " + indexOf.indexOf('a'));
        System.out.println("indexOf('z'): " + indexOf.indexOf('z'));

        /* 목차. 5. trim() _ 공백 무시 */
        String trimStr = "     java     ";
        System.out.println("trimStr: #" + trimStr + "#");
        System.out.println("trim(): #" + trimStr.trim() + "#");

        /* 목차. 6. toLowerCase()/toUpperCase() _ 대문자/소문자로 바꿔주는 것*/
        String caseStr = "javamariaDB";
        System.out.println("toLowerCase(): " + caseStr.toLowerCase());
        System.out.println("toUpperCase(): " + caseStr.toUpperCase());

        /* 목차. 7. substring() */
        String javamariaDB = "javamariaDB";
        System.out.println("substring(3, 6): " + javamariaDB.substring(3, 6));
        System.out.println("substring(3): " + javamariaDB.substring(3));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 8. replace() */
        System.out.println("replace(): " + javamariaDB.replace("java", "python"));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 9. length() _ 문자열은 메소드임(길이), 배열(크기) 구분하여 알기*/
        System.out.println("length(): " + javamariaDB.length());
        System.out.println("빈 문자열의 길이: " + "".length());

        /* 목차. 10. isEmpty() _ 맞냐 아니냐?*/
        System.out.println("isEmpty(): " + javamariaDB.isEmpty());
        System.out.println("isEmpty(): " + "abc".isEmpty());




    }



}
