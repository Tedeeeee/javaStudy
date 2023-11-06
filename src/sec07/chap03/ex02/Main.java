package src.sec07.chap03.ex02;

public class Main {
    public static void main(String[] args) {
        // 선언시 각각 자료형에 각 타입의 변수 자료형을 명시해야 한다.
        // 제네릭은 원시 값은 쓸수 없다. 클래스만 사용 가능하다
        Pocket<Double, Double, Double> size3d1 =
                new Pocket<>(123.45, 234.56, 345.67);

        // 타입 추론도 물론 가능하다.
        // 위의 경우와 달리 < > 에 Double 을 세번 적지 않아도 알아서 추론을 하는 것을 볼 수 있다.
        var size3d2 =
                new Pocket<>(123.45, 234.56, 456.78);

        double width = size3d1.getFieldA();
        double height = size3d1.getFieldB();
        double depth = size3d1.getFieldC();

        // 이런식으로 한 클래스에 다양한 타입의 인자를 받을 수 있다.
        Pocket<String, Integer, Boolean> person =
                new Pocket<>("홍길동", 20, false);

        // 제네릭 클래스는 배열을 생성 할 때 new 를 통해 꼭 초기화를 해주어야 한다.
        Pocket<String, Integer, Boolean>[] people = new Pocket[]{
                new Pocket<>("홍길동", 20, false),
                new Pocket<>("전우치", 30, true),
                new Pocket<>("임꺽정", 27, true)
        };
    }
}
