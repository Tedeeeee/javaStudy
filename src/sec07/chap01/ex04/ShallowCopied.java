package src.sec07.chap01.ex04;

public class ShallowCopied implements Cloneable{
    String title;
    int no;
    int[] numbers;
    Click click;
    Click[] clicks;

    public ShallowCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        // Cloneable 을 구현하므로 정상적인 작동이 된다.
        // 원시값이 완전히 복사
        return super.clone();
    }
}
