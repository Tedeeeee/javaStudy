package src.sec07.chap01.ex04;

public class NotCloneable {

    // 원시타입 필드
    String title;
    int no;

    // 참조타입 필드
    int[] numbers;
    Click click;
    Click[] clicks;

    public NotCloneable(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        /**
         *   Cloneable 을 구현하지 않은 클래스에서 호출하면 오류가 발생한다
         *   아래의 코드를 호출 하지 않는다면 오류는 나지 않지만 원시값 복사까지 모두 일일이 해주어야 한다.
         *   그럴거면 clone 을 왜 Override 해...
         */
        // return new NotCloneable(title, no, numbers, click, clicks);

        // 이렇게 super.clone 을 통한 복사를 얕은 복사라고 한다.
        // 이는 원시타입은 복사해주지만 참조타입은 참조 복사만 이루어 진다.
        return super.clone();
    }
}
