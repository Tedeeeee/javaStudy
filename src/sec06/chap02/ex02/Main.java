package src.sec06.chap02.ex02;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("Enter");
        Button button2 = new Button("CapsLock");
        Button button3 = new Button("ShutDown");

        // 이런식으로 다양한 버튼이 있고 모든 버튼이 전부 능력이 1회용이라면 이렇게 익명 클래스를 사용해서 한번만 사용하고 지워지는 클래스를 만들면 편하다.
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("줄 바꿈");
                System.out.println("커서를 다음 줄에 위치한다");
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("기본 입력 대소문자 전환");
            }
        });

        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("작업 자동 저장");
                System.out.println("프로그램 종료");
            }
        });

        for (var button : new Button[]{button1, button2, button3}) {
            button.func();
        }
    }
}
