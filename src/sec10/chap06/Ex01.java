package src.sec10.chap06;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        String nulStr = null;
        // 여기서 발생하는 것이 바로 NPE 이다.
        // System.out.println(nulStr.length());

        // 이것도 false 가 나온다면 NPE 가 발생하는 것이다.
        //System.out.println(
        //        catOtNull().length()
        //);

        // NPE 오류를 try - catch 문으로 대비해보자
        try {
            System.out.println(
                    catOtNull().length()
            );
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            System.out.println(0);
        }
    }

    public static String catOtNull() {
        // 슈뢰딩거의 고양이를 생각해보자
        return new Random().nextBoolean() ? "Cat" : null;
    }
}
