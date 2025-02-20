import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // 클래스의 클래스타입
public class AddtionalAnnotationTest {


    @Disabled
    @Test
    public void testIgnore() {}

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(900);          // Thread.sleep을 활용하면 밀리초만큼 지연ㄱ 가능
//        Thread.sleep(1001);
    }


    /* 설명. 클래스 위에 TestMehodOrder 어노테이션을 추가해야 한다 */
    @Test
    @Order(1)   //낮은 번호일수록 순위가 높다
    public void testFirst() {}

    @Test
    @Order(3)
    public void testThird() {}


    @Test
    @Order(2)
    public void testSecond() {}

}
