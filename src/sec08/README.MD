## 컬렉션 프레임워크

### 1. 리스트
- 순서가 있는 요소들의 컬렉션 ( 크기가 변할 수 있다. )
- 중복을 허용한다.

<br>

#### ArrayList `( arrayList 의 파일에 Main.java 를 확인 )`
   - 가장 많이 사용되는 컬렉션 클래스
   - 요소들을 들어오는 순서대로 저장한다.
   - 장점
     - 각 요소들의 접근이 굉장히 빠르다 (random Access)
   - 단점
     - 요소 추가 / 제거 시 성능 부하, 메모리를 더 많이 차지한다
     

<br>

#### LinkedList `( LinkedList 의 파일에 Main.java 를 확인 )`
- Queue 를 구현할 때 사용한다 Tree 와 Graph 등에도 사용되는 모습을 볼 수 있다.
- 대다수의 기능이 ArrayList 와 공유한다
- 장점
  - 요소의 추가와 제거가 빠르다
  - 비연속적인 저장이지만 위치를 저장하는 방식이라서 메모리를 절약 할 수 있다
- 단점
  - 접근이 ArrayList 에 비해 느리다

<br>

### 2. 셋
- 중복되지 않는 요소들의 집합

<br>

#### set `( set 의 파일에 Main.java 를 확인 )`
1. HashSet
   - 장점
     - 성능이 빠르고 메모리를 적게 사용한다
   - 단점 
     - 순서 관련 기능이 없다 ( 순서를 보장하지 않는다. )
2. LinkedHashSet
   - 장점
     - 요소들을 입력 순서대로 정렬한다. ( 내부적으로 링크를 사용한다 )
   - 단점
     - HashSet 에 비하여 성능이 좋지 않다
3. TreeSet
   - 장점
     - 요소들을 특정 기준대로 정렬 할 수 있다. ( 기본 셋팅 : 오름차순 )
   - 단점
     - 데이터 추가 / 삭제에 더 긴 시간을 소모하게 된다.
   - TreeSet 을 사용하는 대표적인 알고리즘으로 Red - Black Tree 라는 것이 있다.
   - 객체를 넣을때는 정렬이 되어야 하기때문에 그냥 넣으면 안되고 Comparable 또는 Comparator 둘중 하나를 사용해야한다.


### 3. 맵
- 키와 값의 쌍을 이루고 있는 자료구조이다
- 자료형은 다양하게 사용이 가능하다
- 키값은 중복될수 없다 하지만 value 값은 중복되어도 상관이 없다

<br>

#### map `( map 의 파일에 Main.java 를 확인 )`
1. map
   - 트리를 생성하는 방법은 HashMap 과 TreeMap 으로 이루어져있다
   - 정렬과는 무관하고 빠른 접근 시에는 해시맵, 키 순으로 정렬 필요시에 트리맵
   - HashMap : 키의 해시 코드 / 키로 저장한다.
   - TreeMap : 키를 트리 형태로 저장한다.

<br>

### 4. Comparable & Comparator `comparatorcomparable 의 파일에 Main.java 를 확인`
- 둘 모두 인터페이스이다 굉장히 중요하다 인터페이스이다.
- Comparable : 자신과 다른 객체를 비교
  - 숫자 클래스, Boolean, String, Date, BigDecimal, BigInteger 등
- Comparator : 비교의 주체 두 개를 주어주고 비교한다
  - 컬렉션에서는 정렬의 기준으로 사용된다
  - Arrays 의 sort 메소드에서 사용되는 것이다. 
  - TreeSet, TreeMap 의 생성자에서 활용된다. Comparator 를 통해 Tree 가 정렬된다는 것이다.

<br>

### 5. Iterator `iterator 의 파일에 Main.java 를 확인`
- java.lang.Iterable 인터페이스 구현 클래스에서 사용한다
- 컬렉션을 순회하는데사용한다
  - 특정 기준의 요소들 제거에 유용하다
  - 순회 상태가 저장될 필요가 있을 때 유용하다.

- **Collection 을 다룰때는 동시성을 주의해야한다. 때문에 우리가 사용하는 forEach 문을 주의해서 사용해야 한다.**
