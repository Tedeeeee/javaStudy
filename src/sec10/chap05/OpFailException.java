package src.sec10.chap05;

public class OpFailException extends Exception {
    public OpFailException() {
        super("\uD83D\uDC80 작전 실패!");
    }
}
