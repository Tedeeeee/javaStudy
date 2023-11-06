package src.sec05.chap07;

public class Main {
    public static void main(String[] args) {
        String tsCreed = TaesikChicken.CREED;

        // TeasikChicken 에서 final로 선언한 것을 초기화하는 것은 불가능하다.
        // TaesikChicken.CREED = "우리의 튀김옷이 어쩌다";

        final TaesikChicken store1 = new TaesikChicken(3, "판교");

        // final 로 선언된 인스턴스를 새로운 생성자를 통해 초기화하는 것은 불가능 하다
        // store1 = new TaesikChicken(17, "강남");

        // 하지만 요소는 변경할 수 있다.
        store1.name = "선릉";

        // 하지만 내부의 필드가 final 로 선언되어 있는 no는 역시 바꿀수 없다.
        // store1.no = 3;


        /**
         *  final 로 선언된 필드는 한 번 초기화된 값을 다시 변경 될 수 없다.
         *
         *  final 필드
         *  - 값을 변경 할 수 없다.
         *  - 필드 선언 시 또는 생성자에서 초기화 해야한다.
         *
         *  final 메소드
         *  - 자식 클래스에서 오버라이드가 불가능 하다
         *  - final 로써 한번 제작한 것은 재조정이 안되는 것이다
         *
         *  final 클래스
         *  - 하위 확장 불가 ( 자식 클래스를 만들 수 없다 )
         */


    }
}
