package src.sec07.chap01.ex04;

public class DeepCopied implements Cloneable{

    String title;
    int no;
    int[] numbers;
    Click click;
    Click[] clicks;

    public DeepCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    // 앞선 clone 과는 다르게 좀 더 상세하게 로직을 짠다.
    @Override
    protected Object clone() throws CloneNotSupportedException {

        // 1. 원시 값을 복사한다.
        DeepCopied clone = (DeepCopied) super.clone();

        // 2. 얕게 복사되어있는 참조 값을 깊게 복사하기 위해 하나하나 복사를 한다
        clone.numbers = new int[numbers.length];
        for (var i = 0; i < numbers.length; i++) {
            clone.numbers[i] = numbers[i];
        }

        clone.click = new Click(click.x, click.y);

        clone.clicks = new Click[clicks.length];
        for (var i = 0; i < clicks.length; i++) {
            clone.clicks[i] = new Click(clicks[i].x, clicks[i].y);
        }

        return clone;
    }
}
