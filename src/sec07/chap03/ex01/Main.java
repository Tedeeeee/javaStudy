package src.sec07.chap03.ex01;

import src.sec05.chap08.ex01.TaesikChicken;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int randNum = pickRandom(123, 456);
        boolean randBool = pickRandom(true, false);
        String randStr = pickRandom("마루치", "아라치");

        TaesikChicken store1 = new TaesikChicken("판교");
        TaesikChicken store2 = new TaesikChicken("역삼");
        TaesikChicken randStore = pickRandom(store1, store2);

        // 이런식으로 타입과 인자 타입이 일치하지 않으면 반환하는 값이 맞지 않아진다.
        // double randFlt = pickRandom("hello", "world");
        double randDbl = pickRandom(12, 34);

        var array1 = new Double[]{
                1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8
        };
        var array2 = new Character[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
        };

        arraySwap(array1, 3, 5);
        arraySwap(array2, 2 ,7);

        for (var i = 0; i < 100; i++) {
            arraySwap(
                    array2,
                    (int) Math.floor(Math.random() * array2.length),
                    (int) Math.floor(Math.random() * array2.length)
            );
        }
    }

    // T : 타입 변수, 원하는 어떤 이름으로든 자체적으로 명명 가능하다.
    // 해당 메소드는 반환값이 T 이다. 인자 또한 T 인것을 볼 수 있다.
    public static <T> T pickRandom(T a, T b) {
        return Math.random() > 0.5 ? a : b;
    }

    public static <T> void arraySwap(T[] array, int a, int b) {
        if (array.length <= Math.max(a, b)) return;

        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
