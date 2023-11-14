package src.sec10.chap04;

import java.util.HashMap;
import java.util.Map;

public class Ex04 {

    public static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("정핫훈", 3);
        dutyRegMap.put("김돌준", 8);

        dutyRegMap.forEach((name, month) -> {
            try {
                chooseDutyMonth(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace();
                System.out.printf("%s씨 지금 해보자는 거야?%n", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public static void chooseDutyMonth(String name, int index) throws WrongMonthException {
        int[] availables = {1, 3, 5, 7, 8, 12};

        try {
            int month = availables[index - 1];
            System.out.printf("%s씨 %d월 담당으로 배정 되셨습니다.%n", name, month);
        } catch (ArrayIndexOutOfBoundsException ae) {
            WrongMonthException we = new WrongMonthException(
                    "%d번은 없어요.".formatted(index)
            );

            // 예외의 원인이 되는 예외를 지정한다. ( 이를 수행하는 생성자가 없을 경우 )
            we.initCause(ae);
            // 이 예외는 cause 를 입력받는 생성자를 지정해놓는다.

            // 다른 종류의 예외가 발생한다 하더라도 이예외의 원인으로 등록해서 통일된 타입의 예외로 반환이 가능하다.
            throw we;
        }
    }
}
