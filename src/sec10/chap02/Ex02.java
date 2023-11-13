package src.sec10.chap02;

import src.sec07.chap4.*;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        withFinally1(false);
        System.out.println("- - - - - - - - -");
        withFinally1(true);

        System.out.println("- - - - - - - - -");
        System.out.println("- - - - - - - - -");

        var char1 = withFinally2(3);
        var char2 = withFinally2(6);

        System.out.println("- - - - - - - - -");
        IntStream.rangeClosed(0, 4).forEach(i -> withFinally3(i));
    }
    public static void withFinally1(boolean makeException) {
        try {
            if (makeException) System.out.println("".charAt(0));
            System.out.println("\uD83C\uDF89 예외 없이 정상실행됨");
        } catch (Exception e) {
            System.out.println("🛑 예외 발생");
        } finally {
            System.out.println("🏁 무조건 실행");
        }

        // 그냥 try 문 밖에 적으면 안되는 건가?
        System.out.println("try 문 밖에 적힌 코드");
    }

    public static char withFinally2(int index) {
        String str = "Hello";
        try {
            char result = str.charAt(index);
            System.out.println("🎉 예외 없이 정상실행됨");
            return result;
        } catch (Exception e) {
            System.out.println("🛑 예외 발생");
            return '!';
        } finally {
            // 위에서 return 이 발생하더라도 이건 진행 하고 넘어가야한다.
            System.out.println("🏁 무조건 실행");
        }

        // try, catch 블록에 모두 return 이 있기때문에 이 부분은 작성 될 수 없다.
        // try 문에 return 값이 발생하는 경우 withFinally 메소드 자체가 종료되기 때문에 해당 코드는 읽혀질 일이 없다.
        // System.out.println("🏁 이렇게 말이지.");
    }

    public static void withFinally3(int i) {
        try {
            switch (i) {
                case 1:
                    System.out.println((new int[1])[1]);
                case 2:
                    System.out.println("abc".charAt(3));
                case 3:
                    System.out.println((Knight) new SwordMan(Side.RED));
                case 4:
                    System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);
        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        } finally {
            System.out.println("🏁 무조건 실행");
        }
    }
}
