package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto2.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {
       MemberDTO[] memArr = new MemberDTO[10];
        memArr[0] = new MemberDTO("user01", "pass01", "박형민",
                "hm123@gamil.com", 25, '남');
        memArr[1] = new MemberDTO("user01", "pass01", "박형민",
                "hm123@gamil.com", 25, '남');
        memArr[2] = new MemberDTO("user01", "pass01", "박형민",
                "hm123@gamil.com", 25, '남');

        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(
                    new FileOutputStream(
                            "src/main/java/com/ohgiraffers/sectrion03/filterstream/testObject.txt"
                    )
            );

//            oos.writeObject(memArr[0]);
            for (int i = 0; i < memArr.length; i++) {
                oos.writeObject(memArr[i]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //읽어들임 (조회)

        MemberDTO[] newMemArr = new MemberDTO[memArr.length];

        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(
                    new FileInputStream("src/main/java/com/ohgiraffers/sectrion03/filterstream/testObject.txt")
            );

            int index = 0;
            while(true) {
                newMemArr[index++] = (MemberDTO) ois.readObject();
            }

//             newMemArr[0] = (MemberDTO)ois.readObject();                //반환형이 object형  -> 다운캐스팅해야함
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            /*설명. 출력 및 입력까지 완료되었는지 새로운 배열의 회원 정보 확인*/
            for (MemberDTO mem : newMemArr) {

            }

        }
    }
}
