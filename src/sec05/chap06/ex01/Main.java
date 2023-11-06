package src.sec05.chap06.ex01;

public class Main {
    public static void main(String[] args) {
/*
        //  💡 가능 - 자식 클래스는 부모 클래스에 속함
        Button button1 = new Button("Enter");
        Button button2 = new ShutDownButton();
        Button button3 = new ToggleButton("CapsLock", true);

        //  ⚠️ 불가
        // ShutDownButton button4 = new Button("Enter");
        // ToggleButton button5 = new ShutDownButton();

        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button button : buttons) {
            button.func();
        }
*/

        Button button = new Button("버튼");
        ToggleButton toggleButton = new ToggleButton("토글", true);
        ShutDownButton shutDownButton = new ShutDownButton();

        // true
        boolean typeCheck1 = button instanceof Button;
        boolean typeCheck2 = toggleButton instanceof Button;
        boolean typeCheck3 = shutDownButton instanceof Button;

        // false
        boolean typeCheck4 = button instanceof ToggleButton;
        boolean typeCheck5 = button instanceof ShutDownButton;

        // 컴파일 에러
        // 두 개는 Button 의 자식이지 본인들 끼리는 아무 상관없는 애들이라 성립이 안된다.
        // boolean typeCheck6 = toggleButton instanceof ShutDownButton;
        // boolean typeCheck7 = shutDownButton instanceof ToggleButton;

        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button btn : buttons) {
            // ShutDownButton 의 부모 격인 button 이기에 ShutDownButton이 들어오면 continue를 통해 다음으로 진행하고 다른것은 func를 수행한다.
            if (btn instanceof ShutDownButton) continue;
            btn.func();
        }
    }
}
