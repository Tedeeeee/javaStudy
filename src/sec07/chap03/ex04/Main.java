package src.sec07.chap03.ex04;

public class Main {
    public static void main(String[] args) {
        FormClicker<Button> fc1 = new FormClicker<>(new Button());
        FormClicker<Switch> fc2 = new FormClicker<>(new Switch(true));

        // Button 또한 FormElement 를 상속 받았기에 현재 Mode 를 확인할 수 있다.
        fc1.printElemMode();

        // 불을 껐다 켰다 하는 메소드이다.
        fc2.clickElem();

        // 이 두개 모두 오류가 나는 이유는 FormClicker 는 두개를 상속받지만 TextInput 은 하나만 받고 있기에 불가능한것이다.
        // FormClicker<TextInput> fc3 = new FormClicker<>(new TextInput());
        // FormClicker<HyperLink> fc4 = new FormClicker<>(new HyperLink());

    }
}
