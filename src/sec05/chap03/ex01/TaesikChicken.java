package src.sec05.chap03.ex01;

public class TaesikChicken {

    /**
     *  클래스(정적) 요소 : 메모리 중 한 곳만 차지하고 있다
     *  인스턴스 요소 : 각각이 메모리에서 한자리씩 차지하고 있다.
     *                또한 각각은 자신만의 프로퍼티 값까지 가지고 있다.
     */

    // 클래스(정적) 필드와 메소드들 : 본사의 정보와 기능
    // 인스턴스마다 따로 갖고 있을 필요가 없다.
    static String brand = "태식치킨";
    static String contact() {
        // 정적 메소드에서는 인스턴스 프로퍼티를 사용할 수 없다
        // 오롯이 static 이 붙은 값만 사용할 수 있다
        return "%s 입니다. 무엇을 도와드릴까요?".formatted(brand);
    }

    // 인스턴스의 필드로서 인스턴스 생성 후 다룰 수 있다
    int no;
    String name;

    TaesikChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // 인스턴스 메소드에서는 클래스(정적) 필드를 사용할 수 있다.
    String intro() {
        return "안녕하세요, %s %d호 %s점입니다".formatted(brand, no, name);
    }
}
