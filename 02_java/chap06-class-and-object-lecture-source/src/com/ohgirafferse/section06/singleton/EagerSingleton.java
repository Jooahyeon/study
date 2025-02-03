package com.ohgirafferse.section06.singleton;

public class EagerSingleton {
    // 자신의 객체를 만들어 공간에 담음.
    private static EagerSingleton eager = new EagerSingleton();

    private EagerSingleton() {      // private를 통해 딴 데서 호출 못하도록 해야함.(중요)
    }

    // private이기에 static에 직접 접근 불가함 heap 영역에 받아서 사용
    public static EagerSingleton getInstance() {
        return eager;
    }
}
