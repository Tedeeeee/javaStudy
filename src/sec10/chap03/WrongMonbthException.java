package src.sec10.chap03;

public class WrongMonbthException extends RuntimeException {
    public WrongMonbthException(int month) {
        // 최고 조상인 Throwable 의 생성자 확인
        // - detailMessage 에 값을 넣는 오버로드
        super(
                ("당신이 사는 세계에는 %d월이 있나보군요." +
                        "멀티버스 여행이 가능해진다면 " +
                        "저도 꼭 %d월을 살아 보고 싶습니다.")
                        .formatted(month, month)
        );
    }


}
