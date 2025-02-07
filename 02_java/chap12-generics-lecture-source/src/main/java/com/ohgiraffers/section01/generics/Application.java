package com.ohgiraffers.section01.generics;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 제네릭에 대해 이해할 수 있다 */

        MyGenericTest mgt = new MyGenericTest();

        //ME. 받을 땐 object라 모든 타입을 받으나 꺼낼 때 번거로움
        // object로만 구성된 클래스 = 타입의 안전성이 낮다, 불안하다 but 구현의 편리성을 지님(쓸땐 타입 구분 없어도 되서 편함)
        // (왜? 한가지 타입으로 받다보니 꺼낼 땐 구체화해야해서 어려움,심지어 컴파일시 에러도 없음)
        //그래서 나온게 generic

        mgt.setValue("안녕");
        mgt.setValue(1);
        mgt.setValue(3.14);         //마지막 값인 얘가 들어있음

        System.out.println(mgt.getValue().toString());
        //3.14는 double형이라 tostring이 불가, 오토박싱에 의해서 new double()이라는 객체가 되어 출wh  u력 가능 (자동_과정)
        double dNum = (Double)mgt.getValue();//T. 컴파일 에러가 아닌 런타임 에러가 발생하는 위험한 구문(자료형이 안전하지 않음)
        //주소값을 값을 넣는 곳에 넣을 수 없어 다운캐스팅함 (수동으로 해줘야 해) -> 번거로움

        GenericTest<Double> gt1 = new GenericTest<>(); // 다이아몬드 연산자는 한 번마 ㄴ타입까지 작성하면 된다.
        gt1.getValue();     // T. 다이아몬드연산자 안의 참조자료형을 반환하게 되는 것을 확인할 수 있다.
//        gt1.setValue(1);    // T. 타입의 안전성이 높다(=컴파일에러를 띄워준다, 다이아몬드연산자 안 참조자료형을 위반하지 않는다)


        /*설명.
        *  제네릭 클래스는 다양한 자료형으로 변환할 수 있어 클래스 하나만으로 활용가치가 높아진다 (구현의 편의성)
        *  매개변수나 반환형도 제네릭 타입으로 지정되어 명확히 해당 타입에 대해 처리할 수 있다(타입의 안전성)
        * */

    }

}
