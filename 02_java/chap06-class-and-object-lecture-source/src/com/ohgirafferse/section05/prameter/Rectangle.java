package com.ohgirafferse.section05.prameter;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle() {

    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void calArea() {
        System.out.println("사각형의 넓이는 " + (width * height));

    }

    public void calRound() {
        System.out.println("사각형의 둘레는 " + (width + height) * 2);
    }

}
