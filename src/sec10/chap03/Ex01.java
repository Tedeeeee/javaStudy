package src.sec10.chap03;

import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {

        // 예외는 오류가 던져지면 그 아래의 코드는 작성이 불가능 함
        throw new RuntimeException();

        // 메세지를 특정하여 던지기
        // throw new RuntimeException("뭔가 잘못 되었습니다");

        // 원인이 되는 다른 예외들을 명시하여 던지기
        //throw new RuntimeException("얘네 떄문이다",
        //        new IOException(
        //                new NullPointerException()
        //        )
        //);
    }
}
