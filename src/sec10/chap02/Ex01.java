package src.sec10.chap02;

import src.sec07.chap4.*;

import java.util.stream.IntStream;

public class Ex01 {

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 4).forEach(Ex01::tryThings1);

        System.out.println("\n- - - - - - - - -\n");

        IntStream.rangeClosed(0, 4).forEach(Ex01::tryThings2);

        System.out.println("\n- - - - - - - - -\n");

        IntStream.rangeClosed(0, 4).forEach(Ex01::tryThings3);
    }
    public static void tryThings1(int i) {
        try {
            switch (i) {
                // 예외가 발생하면 바로 실행을 멈추고 catch 문으로 넘어간다.
                // 아래의 케이스들은 각각 예외가 발생하는 경우로 break 를 따로 넣지 않아도 된다.
                case 1:
                    System.out.println((new int[1])[1]);
                case 2:
                    System.out.println("abc".charAt(3));
                case 3:
                    System.out.println((Knight) new SwordMan(Side.RED));
                case 4:
                    System.out.println(((String) null).length());
            }

            // 이렇게 switch 문 밖에 있는 코드는 예외가 발생하지 않아야 실행된다.
            System.out.printf("%d : \uD83C\uDF89 예외 없이 정상실행됨%n", i);
        } catch (Exception e) {
            // 예외가 발생한다면 실행되는 블록이다.
            System.out.printf(
                    "%d : \uD83D\uDED1 [ %s ] %s%n", i, e.getClass(), e.getMessage()
            );
            e.printStackTrace();
        }
    }

    // 위에서 모든 case 의 예외가 발생하는 수를 모두 catch 문을 통해 잡을 수 있다.
    // 그리고 그 예외에 대한 문구도 잡아낼수 있다.
    public static void tryThings2(int i) {
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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("%d : 🍡 배열의 크기를 벗어남%n", i);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🔤 문자열의 길이를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            // 직접 작성하지 못한 예외에 대한 처리로 가장 밑에서 받아야 한다.
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }
    }

    public static void tryThings3(int i) {
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
        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            // 둘 이상의 예외 타입들에 동일하게 대응하는 경우
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }
    }
}
