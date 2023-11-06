package src.sec05.chap08.ex01;

public abstract class TaesikGroup {
    protected static final String CREED = "우리의 %s(는) 뛰어나다";

    // 클래스 메소드에 abstract 는 불가능 하다
    // abstract static final String getCreed();

    protected final int no;
    protected final String name;

    public TaesikGroup(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String intro() {
        return "%d호 %s점입니다.".formatted(no, name);
    }

    // 실습을 위한 public abstract 메소드
    public abstract void takeOrder();
}
