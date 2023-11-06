package src.sec05.chap01.ex03;

public class TaesikChicken {
    int no;
    String name;

    // 생성자 : 인스턴스를 만드는 메소드
    public TaesikChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    String intro() {
        return "안녕하세요, %d호 %s점입니다".formatted(no, name);
    }

}
