package src.sec09.chap01;

@FunctionalInterface
public interface Printer {
    void print();

    // 두 개 이상 의 메소드는 사용할 수 없다
    // void say();
}
