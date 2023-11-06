package src.sec07.chap03.ex02;

// 원하는 자료형들로 세 개의 필드를 갖는 클래스이다.
// 각각의 자료형은 물론 다양한 타입의 자료형들이 들어갈 수 있다.
public class Pocket<T1 ,T2, T3> {
    private T1 fieldA;
    private T2 fieldB;
    private T3 fieldC;

    public Pocket(T1 fieldA, T2 fieldB, T3 fieldC) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        this.fieldC = fieldC;
    }

    public T1 getFieldA() {
        return fieldA;
    }

    public T2 getFieldB() {
        return fieldB;
    }

    public T3 getFieldC() {
        return fieldC;
    }
}
