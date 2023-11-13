package src.sec10.chap01;

public class Main {
    public static void main(String[] args) {

        Throwable throwable;
        Error error;
        Exception exception;
        OutOfMemoryError outOfMemoryError;
        StackOverflowError stackOverflowError;
        RuntimeException runtimeException;
        IndexOutOfBoundsException indexOutOfBoundsException;

        int[] ints = {1, 2, 3};
        // 런타임시에 예외가 발생한다.
        // 이유 : index 3 은 없다.
        // System.out.println(ints[3]);
        System.out.println("예외를 방지하지 않았을 때");

        System.out.println("예외를 try 문으로 감쌌을 때 1번 경우");
        try {
            System.out.println(ints[3]);
        } catch (Exception e) {
            String errMsg = e.getMessage();
            e.printStackTrace();
        }

        System.out.println("예외를 try 문으로 감쌌을 때 2번 경우");
        try {
            System.out.println(((String) null).length());
        } catch (Exception e) {
            String errMsg = e.getMessage();
            e.printStackTrace();
        }

    }

}
