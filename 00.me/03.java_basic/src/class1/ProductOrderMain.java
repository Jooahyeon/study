package class1;

public class ProductOrderMain {
    public static void main(String[] args) {
        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder[] jumun = new ProductOrder[3];

        ProductOrder dubu = new ProductOrder();
        dubu.productName = "두부";
        dubu.price = 2000;
        dubu.quantity = 2;
        jumun[0] = dubu;

        ProductOrder gimchi = new ProductOrder();
        gimchi.productName = "김치";
        gimchi.price = 5000;
        gimchi.quantity = 1;
        jumun[1] = gimchi;

        ProductOrder cola = new ProductOrder();
        cola.productName = "콜라";
        cola.price = 1500;
        cola.quantity = 2;
        jumun[2] = cola;

        int totalAmount = 0;
        for (ProductOrder order : jumun) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        totalAmount += order.quantity * order.price;
        }
        System.out.println("총 결제 금액: " + totalAmount);



        // 상품 주문 정보를 `ProductOrder` 타입의 변수로 받아 저장
        // 상품 주문 정보와 최종 금액 출력
    }
}
