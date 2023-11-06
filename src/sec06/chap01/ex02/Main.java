package src.sec06.chap01.ex02;

public class Main {
    public static void main(String[] args) {
        // 팀을 만든다
        TaesikChicken.LaunchTF launchTF1 = new TaesikChicken.LaunchTF("강남", "최루이");
        TaesikChicken.LaunchTF launchTF2 = new TaesikChicken.LaunchTF("판교", "강상사");

        // 가게를 만든다
        TaesikChicken store1 = launchTF1.launch();
        TaesikChicken store2 = launchTF2.launch();

        TaesikChicken.Gift[] gifts = {
                store1.getGift("홍길동"),
                store1.getGift("박남길"),
                store2.getGift("최가강")
        };
    }
}
