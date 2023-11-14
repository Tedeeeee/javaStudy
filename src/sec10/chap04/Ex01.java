package src.sec10.chap04;

import java.io.FileNotFoundException;
import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        maybeException2();
    }

    // RuntimeException 과 그 자손들 : unchecked 예외
    // 주로 개발자의 실수로 인해 발생하는 예외
    // 예외 처리가 필수가 아니다. ( 하지 않아도 컴파일이 가능하다. )
    public static void maybeException1() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        }
    }

    // 다른 예외는 checked 예외
    // 해당 메소드 내에서, 또는 호출한 곳에서 예외처리 필수
    // 외적 요인으로 발생하는 예외 ( 이건 조심해도 소용이 없다 때문에 대비를 해야한다. )
    // IDE의 안내에 따라서 두 가지 옵션을 실행해보는 것이 좋다.
    public static void maybeException2(){
        if (new Random().nextBoolean()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
