package src.sec05.chap04.ex03;

public class Product {
    private static double discount = 0.2;
    private static double increaseLimit = 1.2;

    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) return;
        this.name = name;
    }

    public int getPrice() {
        return (int) (price * (1 - discount));
    }

    public void setPrice(int price) {
        // 비싼값의 한계를 지정 해 놓는다.
        int max = (int) (this.price * increaseLimit);
        this.price = Math.min(price, max);
    }
}
