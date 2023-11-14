package src.sec10.chap04;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();

        dutyRegMap.put("정핫훈", 7);
        dutyRegMap.put("김돌준", 13);

        // 예외를 던진 메소드 registerDutyMonth 를 사용할때 해당 메소드에서 처리를 한다
        // 처리 방법은 try catch 문을 활용한다.
        dutyRegMap.forEach((name, month) -> {

            // 실행부에서, 혹은 또 이를 호출한 외부에서 처리해주어야 한다.
            try {
                registerDutyMonth(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace();
                System.out.printf("%s씨 에어팟 빼보세요.%n", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        dutyRegMap.forEach((name, month) -> {
            try {
                registerDutyMonthSafer(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace();
                System.out.println("내가... 왜 또 불렀는지 이제는 알죠?");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // 예외를 던질 가능성이 존재하지만 스스로 처리하지 않는 메소드
    public static void registerDutyMonth(String name, int month) throws WrongMonthException {
        if (month < 1 || month > 12) {
            throw new WrongMonthException("하....직원 교육 좀 해서 보내주세요");
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨습니다.%n", name, month);
    }

    // 우선 예외 처리를 본인(메소드) 스스로 처리하면서 추가로 외부로 던져서 호출부에서도 또다시 예외ㅏ를 처리한다
    // 필요한 일은 하되, 정상적으로 진행된 것은 아님을 호출부에 알리기 위한다.
    // 예외를 양쪽에서 처리해줄 필요가 있을 때 사용할 수 있다.
    public static void registerDutyMonthSafer(String name, int month) throws WrongMonthException {
        try {
            if (month < 1 || month > 12) {
                throw new WrongMonthException("우선 저희가 아무 달에 배정을 진행 할게요");
            }
            System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
        } catch (WrongMonthException we) {
            System.out.printf("%s씨 %d월 담당으로 배정되셨습니다.%n", name, new Random().nextInt(1, 12 + 1));
            throw we;
        }
    }
}
