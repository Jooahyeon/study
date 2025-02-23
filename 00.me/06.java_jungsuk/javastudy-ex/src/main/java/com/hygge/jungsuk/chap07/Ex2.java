package main.java.com.hygge.jungsuk.chap07;

public class Ex2 {
    class SutdaDeck {

        final int CARD_NUM = 20;
        SutdaCard[] cards = new SutdaCard[CARD_NUM];        // 배열만 생성해 둔 것, 객체 생성 별도로 해줘야 해

        SutdaDeck() {

            // num과 iskwang의 조건식 설정
            for (int i = 0; i < cards.length; i++) {
                int num = i % 10 + 1;
                boolean iskwang = (i < 10) && (num == 1 || num == 3 || num == 8);

                cards[i] = new SutdaCard(num, iskwang);
            }
        }
            /* (문제) 정의된 세개의 매서드를 작성하시오*/
            // 메서드 기본 형식 : 반환타입 메서드명(매개변수 목록) {실행코드}

//            [내가 푼 식]
//            public void shuffle(){
//                int sh = Math.random(cards);
//            }
//
//            public SutdaCard pick(int index) {
//                int index =
//                return;
//            }
//
//            public SutdaCard pick() {
//
//            }

//            [정답]
            private void shuffle() {
                for (int i = 0; i < cards.length; i++) {
                    int j = (int) (Math.random() * cards.length);

                    // cards[i]와 cards[j]의 값을 서로 바꾼다..  왜?? (아래 설명)
                    SutdaCard tmp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = tmp;
                }
            }

            // 지정된 위치 반환
        SutdaCard pick(int index) {
            if (index < 0 || index >= CARD_NUM)    // index에 값이 있는지 검사
                return null;                       // 값이 없다면 null
            return cards[index];                   // 값이 있다면 해당 위치 반환

        }

        // 임의의 위치 반환
        SutdaCard pick() {
                int index = (int)(Math.random()* cards.length);
            return pick(index); // pick(int index) 호출
        }

    }

     class SutdaCard {
            int num;
            boolean isKwang;

            SutdaCard() {
                this(1, true);
            }

            SutdaCard(int num, boolean isKwang) {
                this.num = num;
                this.isKwang = isKwang;
            }

            //info() 대신 Obeject클래스의 toString()을 오버라이딩 했다.
            public String toString() {
                return num + (isKwang ? "K" : "");
            }
     }

     class Exercise7_2 {
            public void main(String args[]) {
                SutdaDeck deck = new SutdaDeck();

                System.out.println(deck.pick(0));
                System.out.println(deck.pick());
                deck.shuffle();

                for (int i = 0; i < deck.cards.length; i++) {
                    System.out.println(deck.cards[i] + ",");

                    System.out.println();
                    System.out.println(deck.pick(0));
                }
            }
     }
}


/* 교환방식 대신에 Math.random()으로 위치 뒤섞을 수 있지 않나??
*
* 교환 방식을 활용하는게 더 직관적이고 효율적임
* Math.random()을 이용한 섞기 방식은
* 배열의 인덱스를 랜덤하게 선택하여 각각의 카드를 그 위치로 이동시키는 방식이 될 수 있습니다.
* 하지만 이 방식은 교환 방식보다 고려할 부분이 많아 비효율적일 수 있으며,
* 배열 내에서 중복된 위치가 선택될 수 있기 때문에 교환 방식이 더 일반적으로 사용됩니다.
* */
