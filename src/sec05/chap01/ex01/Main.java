package src.sec05.chap01.ex01;

public class Main {
    public static void main(String[] args) {

        // 인스턴스를 생성하는 과정
        // 인스턴스 : 속성들과 기능들의 묶음
        Button button1 = new Button('1', 1, "DARK");
        Button buttonPlus = new Button('+', 3, "DARK");
        Button buttonClear = new Button('C', 2, "DARK");

        button1.place();
        buttonPlus.place();
        buttonClear.place();
    }
}
