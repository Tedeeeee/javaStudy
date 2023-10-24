package src.sec03.chap01;

public class Ex02 {
    public static void main(String[] args) {
        byte byteNum;
        int smallIntNum = 123;

        // 명시적(강제) 형변환
        // - 개발자 : "제가 책임질테니 그냥 넣어주세요."
        byteNum = (byte) smallIntNum;
    }
}
