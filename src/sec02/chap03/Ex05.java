package src.sec02.chap03;

public class Ex05 {
    public static void main(String[] args) {
        //  💡 final 연산자 : 변수의 값을 바꾸지 못하게 만듦
        final int INT_NUM = 1;
        //INT_NUM = 2; // ⚠️ 불가

        // 상수는 대문자와 _ 를 사용
        // 변수나 메소드는 낙타 표기법을 사용한다.

        //  사용 가능
        int yalco, _yalco, $yalco, 얄코;

        // 숫자나 특수기호는 사용 불가
        /*
        int 1yalco;
        int yal co;
        int #yalco;
        */

        // Java 내에 특정 의미를 갖는 단어들은 변수로 사용 불가
        /*
        int double;
        boolean instanceof;
        char new;
        */

    }
}
