package src.sec08.linkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> intNums = new LinkedList<>();
        for (var intNum : new int[] {2,3,4}) {
            intNums.add(intNum);
        }

        /**
         *  ArrayList 에는 없는 LinkedList 에 있는 독특한 메소드
         *  두 개다 Collection 인 List 를 기준으로 만들어졌기 때문에 사용되는 메소드는 굉장히 닮았다
         *  하지만 LinkedList 에는 있고 ArrayList 에는 없는 메소드들이 있다.
         */

        // 배열에서 가장 앞에 해당 인자의 값을 넣는다.
        intNums.addFirst(1);
        intNums.addFirst(0);

        // 배열에서 가장 뒤에 해당 인자의 값을 넣는다
        intNums.addLast(5);
        intNums.addLast(6);

        // 앞에서 or 뒤에서 꺼내지 않고 반환한다.
        // peek : 비어있을 경우는 null 을 반환한다.
        Integer peekedFirst = intNums.peekFirst(); // 맨 앞
        Integer peekedLast = intNums.peekLast(); // 맨 뒤

        // get : 비어있을 경우 익셉션(예외)을 발생
        Integer gottenFirst = intNums.getFirst(); // 맨 앞
        Integer gottenLast = intNums.getLast(); // 맨 뒤


        // 앞에서 or 뒤에서 꺼내서 반환한다.
        // poll : 비어있을 경우 null 을 반환한다.
        Integer polledFirst = intNums.pollFirst();
        Integer polledLast = intNums.pollLast();

        // remove : 비어있을 경우 익셉션(예외)을 발생
        Integer removedFirst = intNums.removeFirst();
        Integer removedLast = intNums.removeLast();

        // peek, poll, get, remove 등 어디서 많이 본 메소드이다.
        // Stack 과 Queue 에서 나오는 메소드가 LinkedList 에서도 나온다는 것이다.
        // Stack 과 Queue 또한 이러한 기능을 이용해서 구현한다.

        LinkedList<Character> charLList = new LinkedList<>();

        // push & pop : 스택을 간편하게 구현할 수 있다.
        charLList.push('A');
        charLList.push('B');
        charLList.push('C');
        charLList.push('D');
        charLList.push('E');

        char pop1 = charLList.pop();
        char pop2 = charLList.pop();
        char pop3 = charLList.pop();


    }
}
