package src.sec05.chap02.ex01;

public class Main {
    public static void main(String[] args) {
        Slime slime1 = new Slime();
        Slime slime2 = new Slime();

        // attack 을 하는 행위는 slime1 을 통해 했지만 hp는 slime2 가 닳았다.
        // 참조값 이기에 attack 메소드에서 사용한 값들은 slime2 의 값들인 것이다.
        slime1.attack(slime2);

    }
}
