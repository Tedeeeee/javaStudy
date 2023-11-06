package src.sec05.chap01.ex02;

public class TaesikChicken {

    /**
     * 해당 클래스는 본사이다.
     * 본사는 각각의 매장을 총괄하는 곳이다.
     */

    // 인스턴스를 생성했을때 가지는 필드들
    int no;
    String name;

    // 인스턴스를 생성했을때 가질 메소드
    String intro() {
        return "안녕하세요. %d호 %s점 입니다".formatted(no, name);
    }
}
