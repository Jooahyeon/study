package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. FileReader를 이해하고 활용할 수 있다. */
        FileReader fr = null;
        try {
            try {
                fr = new FileReader("src/main/java/com/ohgiraffers/section02/stream/testReader.txt");

//                FileReader -> 읽어주는 애
//                int readChar = fr.read();
//                System.out.println((char) readChar);

                int readChar = 0;                               //변수에 담아야 중복하지 않게 사용 가능하다
                while ((readChar = fr.read()) != -1) {          //
                    System.out.println((char) readChar);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
