package com.ohgirafferse.section03.uses;

import javax.imageio.IIOException;
import java.io.*;

public class Application1 {
    public static void main(String[] args) throws IOException {
        /* 수업목표. 예외처리를 많이 사용하는 io패키지와 관련된 try-catch 구문을 이해할 수 있다.*/
        /*설명.
        *  예외처리를 가장 많이 사용하게 되는 상황(io 패키지 관련)에서 try-catch구문을 실제 상황과 유사하게 연습해보자.
        *   (아직 배우지 않았으나 입출력 관련 구문을 하나하나 신경쓰기보다는 전체 흐름과 구조에 신경쓰자
        * */

        /*설명. 프로젝트 바로 아래 경로에 test.dat 파일이 있다면 그걸 인지한 File 객체를 생성해 절대경로 출력*/
        System.out.println(new File("test.dat").getAbsolutePath());     //getAbsolutePath() 절대경로를 나타내는 기능
        //ME. 자바에 파일 객체 생성(실제파일 아니고 자바가 파일을 객체로 인지한 것)

        BufferedReader br = null;

        //ME. 통로를 만든 것 / 입출력을 할때마다 이 format으로 해야함
        // 1.  BufferedReader br = null;-> try 밖으로 빼야 함. (지역변수 안되게)
        // 2. 예외가 발생할 경우 고려하여 값을 지정해야 함.
        // br != null -> br이 가리키는 객체가 있을 때

        try {
            br = new BufferedReader(new FileReader(new File("test.dat")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            /*설명.
             *  예외처리 구문과 상관 없이 반드시 구행해야하는 경우 finally에 작성하는데
             *   보통 사용한 자원(resource)를 반납하는 용도로 사용하게 된다.
             * */
            try {
                if (br != null) br.close();
                /*설명.
                 *  입출력에서 사용한 스트림(통로)을 닫아주는 용도의 메소드이다
                 *   스트림이 없을 때 (null)을 고려하고 IOException을 처리해야 제대로 쓸 수 있다.
                 * */
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
