package src.sec10.chap04;

import java.util.stream.IntStream;

public class Ex03 {

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 4).forEach(Ex03::ceo);
    }
    public static void sawon(int i) throws XLargeException, LargeException, MediumException {
        try {
            switch (i) {
                case 1:
                    throw new SmallException();
                case 2:
                    throw new MediumException();
                case 3:
                    throw new LargeException();
                case 4:
                    throw new XLargeException();
                default:
                    System.out.println("저 이제 가봐도 되는 거죠?");
            }
        } catch (SmallException se) {
            System.out.println(se.getMessage() + " : 저 이건 알고 있습니다");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void daeri(int i) throws XLargeException, LargeException {
        try {
            sawon(i);
        } catch (MediumException me) {
            System.out.println(me.getMessage() + " : 내가 처리할테니까 가봐요");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void bujang(int i) throws XLargeException {
        try {
            daeri(i);
        } catch (LargeException le) {
            System.out.println(le.getMessage() + " : 잘 합시다 좀...");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void ceo(int i) {
        try {
            bujang(i);
        } catch (XLargeException xe) {
            System.out.println(xe.getMessage() + " : 전원 집합");
        }
        System.out.println("\n- - - - - - - - - - - -\n");
    }
}
