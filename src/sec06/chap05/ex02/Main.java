package src.sec06.chap05.ex02;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        Button.ClickInfo click1 = button.func(123, 456, Button.ClickedBy.RIGHT);
        Button.ClickInfo click2 = button.func(789, 151, Button.ClickedBy.LEFT);
        Button.ClickInfo click3 = button.func(142, 333, Button.ClickedBy.RIGHT);

        for (var click : new Button.ClickInfo[]{click1, click2, click3}) {
            click.printInfo();
        }

        System.out.println("\n- - - - - - - -\n");

        Button.ClickInfo click4 = button.func(111, 222, Button.ClickedBy.LEFT);
        Button.ClickInfo click5 = button.func(111, 222, Button.ClickedBy.LEFT);

        // 만들어진 레코드는 참조형이다.
        // 때문에 == 가 아닌 equal 을 사용해야 한다.
        boolean click4n5Same = click4 == click5;
        boolean click4n5Equal = click4.equals(click5);
        boolean click4n1Equal = click4.equals(click1);

    }
}
