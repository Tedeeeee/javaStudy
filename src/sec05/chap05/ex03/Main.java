package src.sec05.chap05.ex03;

public class Main {
    public static void main(String[] args) {
        Slime slime = new Slime();
        FireSlime fireSlime = new FireSlime();

        // 불 슬라임을 그냥 공격
        slime.attack(fireSlime);

        // 그냥 슬라임을 화염 공격으로 공격
        fireSlime.attack(slime);

        /**
         *  fireSlime 이 slime에 들어갈 수 있는 이유는 다형성 때문이다.
         *  부모 클래스는 모두를 품을 수 있다.
         *  attack 메소드는 인자로 Slime을 받기에 fire 도 slime 도 모두 받을 수 있다.
         *
         *  하지만 반대로 자식은 부모를 품을 수 없다.
         */

    }
}
