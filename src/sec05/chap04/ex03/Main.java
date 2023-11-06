package src.sec05.chap04.ex03;

public class Main {
    public static void main(String[] args) {
        Product ballPen = new Product("볼펜", 1000);

        ballPen.setName("삼색 볼펜");
        // 아무 것도 없는 값은 set에서 받지 않고 return 한다
        ballPen.setName("");

        int ballPenPrice = ballPen.getPrice();

        ballPen.setPrice(1400);
        int price = ballPen.getPrice();
    }
}
