package src.sec08.arrayList;

import src.sec07.chap4.Knight;
import src.sec07.chap4.MagicKnight;
import src.sec07.chap4.Side;
import src.sec07.chap4.SwordMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //  ⭐️ 제네릭을 사용하여 타입 지정
        //  원시 타입은 들어가지 않고 Wrapper class 만 들어간다.
        ArrayList<Integer> ints1 = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Knight> knights = new ArrayList<>();

        //  add 메소드로 요소 추가
        ints1.add(11);
        ints1.add(22);
        ints1.add(33);
        ints1.add(44);
        ints1.add(55);

        //  요소 중복 허용
        for (var str : "바니 바니 바니 바니 당근 당근".split(" ")) {
            strings.add(str);
        }

        //  for-each 문 사용 가능
        for (int i : ints1) {
            System.out.println(i);
        }

        /**
         *  ArrayList 의 생성 및 초기화 방법
         */


        ArrayList<Integer> ints2A = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        ArrayList<Integer> ints2B = new ArrayList<>(
                List.of(1, 2, 3, 4, 5)
        );

        // 이렇게 일일히 정하지 않고 Collections 의 메소드인 addAll 을 통해 인자값을 바로 넣을 수도 있다.
        ArrayList<Integer> ints2C = new ArrayList<>();
        Collections.addAll(ints2C, 1, 2, 3, 4, 5);

        // 다른 Collection 인스턴스를 사용해서 생성한다.
        ArrayList<Integer> ints3 = new ArrayList<>(ints1);

        // 스스로를 복제하여 반환한다 이는 얕은 복사이다.
        ArrayList<Integer> ints4 = (ArrayList<Integer>) ints3.clone();


        /**
         *  제네릭을 적용한 List 사용법
         */

        numbers.add(Integer.valueOf(123));
        numbers.add(3.15);
        // 이처럼 숫자가 아닌 문자는 받을 수 없다.
        // numbers.add("Hello");

        // Swordman 는 Knight 의 부모이기 때문에 할 수 없다.
        // knights.add(new SwordMan(Side.BLUE));
        knights.add(new Knight(Side.BLUE));
        knights.add(new MagicKnight(Side.BLUE));

        // 와일드 카드를 적용
        ArrayList<? extends Knight> eliteSquad;

        // Knight 의 조상인 SwordMan 은 넣을 수 없다.
        // eliteSquad = new ArrayList<SwordMan>();
        eliteSquad = new ArrayList<Knight>();
        eliteSquad = new ArrayList<MagicKnight>();

        // 인스턴스 요소를 지울 때는 참조를 기준으로 내용이 같다고 같은 인스턴스가 아니다.
        Knight knight1 = new Knight(Side.BLUE);
        knights.add(knight1);

        // 참조형을 통해 원하는 요소를 지우는 것의 반환은 boolean 의 타입을 가지고 있다.
        // 이렇게 새롭게 만들어서 찾는 것이 아닌 집어넣은 값이 중요하다
        boolean removed1 = knights.remove(new Knight(Side.RED)); // X
        boolean removed2 = knights.remove(knight1); // O


        /**
         *  List 의 다양한 메소드
         */

        ints1.size(); // 요소의 갯수를 반환하는 메소드
        ints1.isEmpty(); // 해당 배열이 비어있는지 확인하는 메소드로 true or false 를 반환한다.
        ints1.get(1); // get 안에 있는 index 값을 반환하도록 한다.
        ints1.contains(1); // contains 안에 있는 요소가 배열에 포함되어 있는지 알아보는 메소드이다.

        ints1.set(2, 333); // 1번째 인자의 index 를 가진 값을 2번째 인자의 값으로 변환한다.
        ints1.add(0, 11); // 1번째 인자의 index 에 2번째 인자의 값을 추가하는 것 ( 물론 다음 요소들은 모두 shift 된다 )

        Integer remove1 = ints1.remove(4);// 원하는 index 위치에 있는 값을 지운다
        boolean remove2 = ints1.remove((Integer) 55);// index 뿐 아닌 요소의 값으로도 지울 수 있다.
        ints1.removeAll(ints1); // 해당 배열의 모든 값을 지운다

        ints1.addAll(ints3); // 두개의 콜렉션을 이어 붙인다. 물론 인자로 들어간 값이 뒤로 이어 붙는다.

        ints1.clear(); // 리스트를 비운다


        // toArray 를 통해 Object 배열로 반환하는 법
        Object[] intsAry2_Obj = ints1.toArray();

        // Object 가 아닌 다른 타입 배열로 반환하려면 어떻게 해야할가??
        Integer[] ints1Ary2 = ints1.toArray(Integer[]::new);

        /**
         *  Array 와 ArrayList 의 차이
         */

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> list2 = new ArrayList<>(list1);

        var list1Type = list1.getClass().getName();
        var list2Type = list2.getClass().getName();

        // Array 는 한 번 저장한 값을 추가로 저장할 수 없다. = 사이즈 변경이 불가능하다
        // 때문에 Array 를 만들어주게 된다면 add 같은 메소드로 값을 추가해 줄 수 없다.
        // ⚠️ 런타임 오류 ( 컴파일 단계에서는 딱히 문제가 없지만 실행을 하면 오류가 발생한다는 것을 알 수 있다. )

        // list1.add(2);

    }
}
