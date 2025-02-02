package method;

public class MethodReturn1 {
    public static void main(String[] args) {
        //반환 타입이 있으면 무조건 반환을 해야함
        // => 반반환 조건을 만족하도록 작성해야 컴파일 오류 없음
        boolean result = odd(3);
        System.out.println(result);

    }

    public static boolean odd(int i) {
        if (i % 2 == 1) {
            return true;
        } else{
            return false;
        }
    }
}
