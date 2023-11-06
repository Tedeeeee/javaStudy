package src.sec06.chap01.ex02;

public class TaesikChicken {
    private String name;

    public TaesikChicken(String name) {
        this.name = name;
    }

    // 클래스 안의 정적 클래스
    // TF 팀을 만들때 (팀 지역 이름, 팀장이름) 을 적어서 만든다.
    public static class LaunchTF {
        private String title;
        private String leader;

        public LaunchTF(String title, String leader) {
            this.title = title;
            this.leader = leader;
        }

        // 매장을 만드는 메소드가 클래스 안에 정적 클래스에 정의 되어있다?
        public TaesikChicken launch() {
            return new TaesikChicken(title);
        }
    }

    // 클래스 안의 인스턴스 클래스
    class Gift {
        private String message;

        public Gift(String to) {
            this.message = "From 태식치킨 %s점 to %s님".formatted(name, to);
        }
    }

    // Gift 클래스를 외부에서 사용하고자 한다면 get으로 만들어서 주어야 한다.
    public Gift getGift(String to) {
        return new Gift(to);
    }
}
