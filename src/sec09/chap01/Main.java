package src.sec09.chap01;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = new Printer() {
            @Override
            public void print() {
                System.out.println("람다식이 없었을 때의 방식");
            }
        };
        Printer printer2 = () -> {
            System.out.println("인자와 반환값이 없는 람다식");
        };

        // 메소드의 반환값 조차도 없다면 { } 도 없어도 된다
        Printer printer3 = () -> System.out.println("반환값이 없다면 { } 조차도 없다");

        Printer printer4 = () -> {
            System.out.println("코드가 한 줄이 아닌 여러 줄이 된다면");
            System.out.println("{ } 가 필요하다");
        };

        for (var p : new Printer[]{printer1, printer2, printer3, printer4}) {
            p.print();
        }

        Returner returner1 = () -> {
            return 1;};

        Returner returner2 = () -> "반환 코드만 존재한다면 { } 과 return 생략 가능";

        var returned1 = returner1.returnObj();
        var returned2 = returner2.returnObj();

        SingleParam square = (i) -> i * i;
        // 인자로 들어오는 값이 하나라면 ( ) 도 생략이 가능하다.
        SingleParam cube = i -> i * i * i;

        int _3_squared = square.func(3);
        int _3_cubed = cube.func(3);

        DoubleParam add = (a, b) -> a + b;
        DoubleParam multAndPrint = (a, b) -> {
            var result = a * b;
            System.out.printf("%d * %d = %d%n", a, b, result);
            return result;
        };

        var added = add.func(2, 3);
        int multiplied = multAndPrint.func(2, 3);


    }
}
