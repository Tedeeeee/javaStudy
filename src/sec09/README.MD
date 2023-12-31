## 함수형 프로그래밍

<br>

### 1. 람다 `chap01 확인`

<br>

#### 람다식 lambda expression
- 자바 8 에서부터 추가된 기능
- 메소드를 간략히 식 expression 으로 표현
  - ex) `(인자1, 인자2, ... ) -> { 반환값 }`
- 익명 함수 anonymous function 이라고도 부른다
- 자바에서는 인터페이스의 익명 클래스를 간략히 표현하는데 사용된다.

#### 함수형 인터페이스
- 람다식 형태로 익명 클래스가 만들어질 수 있는 인터페이스
  - 조건 : 추상 메소드가 한 개만 있어야 한다.
    - 람다식과 1 : 1 로 만들어지기 때문
    - @FunctionalInterface 로 강제할 수 있다.
    - 클래스 메소드와 default 메소드는 여럿 있을 수는 있다.
  - 예외 : java.util.comparator 는 함수형 인터페이스이지만 추상 메소드가 두개이다.
    - 자바 8 이전에 만들어진 클래스이기 때문이다.
    - 사용자가 정의할 부분은 compare 메소드만 정의하게 되고 equals 는 이미 Object 클래스에 있기때문에 구현 대상이 아니다.
    


<br>

### 2. java.util.function 패키지 `chap02 확인`

- 자바는 람다식을 위한 함수형 인터페이스가 정의되어 있어야한다.
  - 필요할 때마다 정의해야 하므로 번거롭다.
  - 자주 사용하는 인터페이스가 java.util.function 패키지로 제공된다
  - 이는 Stream 에서도 매우 유용하게 사용할 수 있다.
- 대표적인 인터페이스
  - Runnable : run() 
    - 인자값도 없고 반환값도 없다
  - Supplier<T> : get()
    - 인자는 받지 않지만 반환값(T)은 존재한다
  - Consumer<T> : accept()
    - 인자(T)는 받지만 반환값은 존재하지 않는다.
  - Function<T, R> : apply()
    - 인자(T)도 받고 반환값(R)도 존재한다.
  - Predicate<T> : test()
    - 인자(T)는 받지만 반환 값은 boolean 으로 고정이다.

<br>

### 3. 메소드 참조 `chap03 확인`

- Method reference
  - 람다식이 어떤 메소드 하나만 호출할 때 코드를 간편화한다.
    - 즉, 해당 람다식과 메소드의 의미가 사실상 같을때 사용할 수 있다.
  - 해당 메소드가 인터페이스와 인자, 리턴값 구성이 동일할 때 사용한다.

```
# 클래스 메소드 호출
{클래스명}::{클래스 메소드명}

# 인스턴스 메소드 호출
{클래스명}::{인스턴스 메소드명}
{인스턴스}::{인스턴스 메소드명}

# 클래스 생성자 호출
{클래스}::new
```

<br>

### 4. 스트림 `chap05 확인`

- 간단히 말하자면 연속되는 요소들의 흐름이다.
  - 배열, Collection, File 등에서 만들어진다.
- 일련의 데이터를 연속적으로 가공하는데 유용하다
  - 내부적으로 수행 - 중간 과정이 밖으로 드러나지 않는다.
    - 외부에 변수등이 만들어지지 않고 람다식으로 해결한다
  - 배열, Collection, I/O 등을 동일한 프로세스로 가공한다
  - 함수형 프로그래밍을 위한 다양한 기능을 제공한다
  - 이는 간결한 표현으로 가독성을 향상시킨다
- 이는 멀티쓰레딩에서 병렬적인 처리가 가능하다.

<br>

#### 스트림의 연산 방법
- 스트림을 구성하는 것을 보면 여러가지 메소드가 나오는 것을 볼 수 있다. 이중 여러가지와 섞어서 사용하는 것과 끝마칠때 사용하는 메소드가 있는데 그것을 구분해보자
- 중간
  - **peek** : 연산 과정 중 스트림에 영향을 끼치지는 않지만 주어진 Consumer(인자O, 반환X) 작업을 실행한다
  - **filter** : 주어진 Predicate(인자O, 반환(boolean)) 에 충족하는 요소만을 남긴다.
  - **distinct** : 중복되지 않는 요소들의 스트림을 반환한다.
  - **map** : 주어진 Function(인자(1번 타입), 반환(2번 타입)) 에 따라 각 요소들을 변경
  - **sorted** : 요소들을 정렬한다
  - **limit** : 주어진 수 만큼의 요소들을 스트림으로 반환한다.
  - **skip** : 앞에서 주어진 갯수만큼의 요소를 제거한다.
  - **takeWhile / dropWhile** : 주어진 Predicate 를 충족하는 동안 취하거나 건너뛴다.
- 종료
  - **forEach** : 각 요소들에 주어진 Consumer 를 실행
  - **count** : 요소들의 갯수를 반환한다.
  - **min** / max : 주어진 Comparator 에 따라 최소 / 최대 값을 반환한다.
  - **reduce** : 주어진 초기값과 BinaryOperator(인자(2개), 반환(1개)) 로 값들을 하나의 값으로 접어 나간다

<br>

- filter 와 map 의 차이점
  - filter ( Predicate ) : 우리가 원하는 값을 true 와 false 를 기준으로 반환 가능한것과 아닌것들을 나누어 반환하는 것이다.
  - map ( Function ) : 값을 넣으면 받은 값을 반환 타입으로 바꾸어 반환하는 것이다.

<br>

- (원시값)SummaryStatistics : 수의 통계를 인스턴스 형태로 갖는 클래스
  - 그리고 collect 에서 summarising(원시값)을 해주면 map 형태로 묶인 값들의 갯수, 합, 최소, 최대 즉, 통계 값이 모두 나타난다.
  - 물론 원시값의 기준대로 나타낸다.(double 이면 소수점까지 통계값에 나타난다.)

