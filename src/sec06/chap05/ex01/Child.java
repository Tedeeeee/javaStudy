package src.sec06.chap05.ex01;

// 레코드의 필드는 final 과 private 을 기본으로 가지고 있다. 상속은 불가능하다
// 각각의 필드는 getter 가 자동으로 생성된다.
// 인스턴스 필드는 가질 수 없다.
public record Child(
        String name,
        int birthYear,
        Gender gender
){}
