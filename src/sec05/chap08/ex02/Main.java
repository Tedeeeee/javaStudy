package src.sec05.chap08.ex02;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button(2, "Enter");
        Switch switch1 = new Switch(3, true);
        DropDown dropDown1 = new DropDown(5, new String[] {
                "이름 오름차순", "이름 내림차순",
                "크기 오름차순", "크기 내림차순",
                "날짜 오름차순", "날짜 내림차순"
        });

        /**
         *  clickFormElement 는 파라미터로 FormElement를 받는다
         *  하지만 button, switch, dropdown 모두 받아주는 것을 알 수 있다.
         *
         *  이유는 다향성 때문이다. button 도 switch 도 dropdown 버튼도 모두 FromElement를 상속받았기 때문이다.
         */

        clickFormElement(button1);

        clickFormElement(switch1);
        clickFormElement(switch1);
        clickFormElement(switch1);

        clickFormElement(dropDown1);

    }

    // func 를 실행하는 메소드를 따로 만든다.
    public static void clickFormElement(FormElement fe) {
        fe.func();
    }
}
