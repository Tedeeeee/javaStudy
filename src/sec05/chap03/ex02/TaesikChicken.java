package src.sec05.chap03.ex02;

public class TaesikChicken {
    static String brand = "태식치킨";
    static String contact() {
        return "%s입니다. 무엇을 도와드릴까요?".formatted(brand);
    }
    static int lastNo = 0;

    int no;
    String name;

    TaesikChicken(String name) {
        no = ++lastNo;
        this.name = name;
    }

    String intro() {
        return "안녕하세요. %s %d호 %s점입니다.".formatted(brand, no, name);
    }
}
