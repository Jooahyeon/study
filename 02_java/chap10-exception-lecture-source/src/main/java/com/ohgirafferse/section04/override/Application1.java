package com.ohgirafferse.section04.override;

import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        SuperClass subClass = new SubClass();

        try {
            subClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
