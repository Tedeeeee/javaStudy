package src.sec05.chap01.ex03;

public class Main {
    public static void main(String[] args) {

        // Ex02 와 다르게 하나하나 필드를 설정해주는 것이 아닌 생성자를 통해 제작한다.
        // 덕분에 굳이 필드를 일일이 지정해주지 않아도 한줄로 매장들을 저장할 수 있다.
        TaesikChicken store1 = new TaesikChicken(3, "판교");
        TaesikChicken store2 = new TaesikChicken(14, "강남");
        TaesikChicken store3 = new TaesikChicken(67, "아현");

        String[] intros = {store1.intro(), store2.intro(), store3.intro()};
    }
}
