package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        /* 객체단위 입출력 */

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream("src/main/com/ohgiraffers/sectrion03/filterstream/testData.txt"
                    )
            );
            dos.writeUTF("박형민");                //묶음으로 날라가는거라
            dos.writeInt(31);
            dos.writeChar('O');             //각 타입을 맞추는 것

            dos.writeUTF("주아현");
            dos.writeInt(28);
            dos.writeChar('O');

            dos.writeUTF("주현욱");
            dos.writeInt(31);
            dos.writeChar('O');

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new FileInputStream("src/main/com/ohgiraffers/sectrion03/filterstream/testData.txt"
                    )
            );
            while (true) {

                /* 설명. 출력했던 데이터 단위를 지켜서 입력해야 온전히 데이터를 읽어들일 수 있다. */
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }
        } catch (EOFException e) {                          //마지막을 만날 시점 처리 = EOF처리(방법은 다 다름)
            //while무한루프가 돌기때문에 파일을 끝까지 읽었을 때 루프를 종료하도록 도와주는 예외(객체단위로 불러오니께 )
            /*설명. data 단위 입출력은 EOF를 EOFException 처리를 통해 확인하고 처리할 수 있다. */

            System.out.println("데이터 파일 읽기 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
