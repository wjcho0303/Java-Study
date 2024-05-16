package ch07_OOP2;

import java.util.Arrays;
import java.util.Vector;



class BuyerWithCart extends Buyer {
    Product[] cart = new Product[10];

    int i = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.out.println("구매 요청하신 " + p.toString() + "의 가격은 " + p.price + "만원입니다.");
            System.out.println("잔액이 부족하여 구매할 수 없습니다. 현재 남은 잔액은 " + super.money + "만원입니다.");
            return;
        } else {
            this.money = this.money - p.price;
            this.point = this.point + p.bonusPoint;
            System.out.println(p.toString() + "의 가격은 " + p.price + "만원이며, 보너스 포인트는 " + p.bonusPoint + "점입니다. 구매하셨습니다.");
            System.out.println("현재 남은 잔액은 " + this.money + "만원이며, 보유 포인트는 " + + this.point + "점입니다.");
        }
    }

    void putIntoCart(Product p) {
        cart[i++] = p;
        System.out.println(p.toString() + " 상품을 장바구니에 담았습니다.");
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        for (int i = 0; i < cart.length; i++) {
            if(cart[i] == null) break;
            sum = sum + cart[i].price;
            itemList = itemList + cart[i] + ", ";
        }

        itemList = itemList.substring(0, itemList.length() - ", ".length());

        System.out.println("장바구니에 담긴 물품들의 총 금액은 " + sum + "만원입니다.");
        System.out.println("장바구니에 담긴 제품은 " + itemList + "입니다.");
    }

    public BuyerWithCart(int money, int point) {
        super(money, point);
        System.out.println("고객님 환영합니다. 고객님의 현재 잔액은 " + super.money + "만원이며, 보유 포인트는 " + super.point + "점입니다.");
    }
}

public class _13_ArraysAndObjects {
    public static void main(String[] args) {
        // 배열 타입을 조상 타입으로 선언하면 그 배열의 요소에 다양한 타입의 자손 객체를 저장할 수 있다.
        // Refrigerator, Computer, Audio 클래스는 모두 자손 클래스고 공통으로 Product 라는 부모 클래스를 갖고 있다고 하자.

        Product[] cart = new Product[3];     // 상품 3개를 담을 수 있는 장바구니
        cart[0] = new Refrigerator();
        cart[1] = new Computer();
        cart[2] = new Audio();
        System.out.println(cart[0]);    // Refrigerator
        System.out.println(cart[1]);    // Computer
        System.out.println(cart[2]);    // Audio

        // 위와 같이 배열을 선언할 때 참조변수를 조상 타입으로 선언하면 해당 배열 안에 조상 타입 자기 자신은 물론이고,
        // 자손 타입의 인스턴스들도 저장할 수 있다.

        // 참고: Vector 라는 클래스가 있다. 가변 배열 기능을 가진 클래스인데, Vector 클래스에는 Object[] 멤버가 있다.
        // 그래서 모든 종류의 객체를 다 저장할 수 있다.
        // 그리고 배열의 크기를 신경 안 써도 된다. 그냥 add() 메서드로 집어넣기만 하면 된다.
        Vector vectors = new Vector();
        vectors.add(new Refrigerator());
        vectors.add(new Computer());
        vectors.add(new Audio());
        vectors.add(new Object());

        System.out.println(vectors);    // [Refrigerator, Computer, Audio, java.lang.Object@7cc355be]
        System.out.println(vectors.elementAt(0));   // Refrigerator
        System.out.println(vectors.elementAt(1));   // Computer
        System.out.println(vectors.elementAt(2));   // Audio
        System.out.println(vectors.elementAt(3));   // java.lang.Object@7cc355be

        // 요즘은 Collection 프레임워크나 Stream 을 자주 사용하기 때문에 Vector 는 거의 사용되지 않는다.
        // Vector 에 노란 밑줄이 그어져 있는데, 커서를 갖다 대면 "Raw use of parameterized class 'Vector'"
        // 라는 메시지가 나온다.

        // 참고: 배열의 길이는 요소의 개수를 의미하고, 배열의 크기는 배열이 차지하는 메모리 공간을 의미한다.
        // 예를 들어 new int[10]은 배열의 길이가 10 이고, 배열의 크기는 40 byte 다.
        // 그러나 요즘은 자바에서 메모리 공간에 대한 논의는 별로 중요하지 않아서 배열의 길이에도 크기라고 말하는 경향이 있는데,
        // 엄밀하게 말하면 배열의 요소가 몇 개인지 말하려면 "길이"라고 표현하는 것이 바람직하다.
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        BuyerWithCart buyerWithCart = new BuyerWithCart(300, 0);
        buyerWithCart.putIntoCart(new Refrigerator());  // Refrigerator 상품을 장바구니에 담았습니다.
        buyerWithCart.putIntoCart(new Computer());      // Computer 상품을 장바구니에 담았습니다.
        buyerWithCart.putIntoCart(new Audio());         // Audio 상품을 장바구니에 담았습니다.

        buyerWithCart.summary();    // 장바구니에 담긴 물품들의 총 금액은 327만원입니다.
                                    // 장바구니에 담긴 제품은 Refrigerator, Computer, Audio 입니다.

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        buyerWithCart.buy(new Refrigerator());  // Refrigerator 의 가격은 210만원이며, 보너스 포인트는 200점입니다. 구매하셨습니다.
                                                // 현재 남은 잔액은 90만원이며, 보유 포인트는 200점입니다.
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        buyerWithCart.buy(new Computer());      // 구매 요청하신 Computer 의 가격은 105만원입니다.
                                                // 잔액이 부족하여 구매할 수 없습니다. 현재 남은 잔액은 90만원입니다.
    }
}