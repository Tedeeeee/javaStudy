package src.sec07.chap03.ex03;

import src.sec05.chap09.ex01.*;

public class Main {
    public static void main(String[] args) {
        var sum1 = add2Num(12, 34.56);
        // 하지만 Number 의 타입이 아닌 String 이 들어온다면 오류를 발생시킨다
        // var sum2 = add2Num("12", 34.56);

        descHuntingMamal(new PolarBear());
        // 해당 동물은 Mamal 이 아니라서 타입 오류가 발생한다. 때문에 오류를 발생시킨다.
        // descHuntingMamal(new GlidingLizard());

        descFlyingHunter(new Eagle());
        descFlyingHunter(new GlidingLizard());

        // 이 동물은 Fly 하지 못해서 불가능
        // descFlyingHunter(new PolarBear());
    }

    public static <T extends Number> double add2Num(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // 인터페이스 이지만 제네릭의 상속은 모두 extends 로 표시한다.
    // 또한 여러 개일 경우 & 로 나뉜다.
    public static <T extends Mamal & Hunter & Swimmer> void descHuntingMamal(T animal) {
        System.out.printf("겨울잠 %s%n", animal.hibernation ? "잠" : "자지 않는다");
        animal.hunt();
    }

    public static <T extends Flyer & Hunter> void descFlyingHunter(T animal) {
        animal.fly();
        animal.hunt();
    }
}

