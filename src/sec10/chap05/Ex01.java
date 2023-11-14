package src.sec10.chap05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        var correctPath = "./src/sec09/chap04/turtle.txt";
        var wrongPath = "./src/sec09/chap04/rabbit.txt";

        openFile1(correctPath);
        openFile1(wrongPath);

        System.out.println("\n- - - - - - - - -\n");

        openFile2(correctPath);
        openFile2(wrongPath);
    }
    public static void openFile1(String path) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf(" ⚠\uFE0F %s 파일 없음%n", path);
        } finally {
            System.out.println("열었으면 닫아야겠지?");
            if (scanner != null) scanner.close();
        }
    }

    public static void openFile2(String path) {
        // Scanner 가 Closable - AutoClosable 를 구현한다는 것을 확인

        // try 에서 적힌 scanner 는 Clasable 을 Implements 하고 있다
        // 또한 Closable 은 close() 라는 메소드를 가지고 있다.
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("⚠️ %s 파일 없음%n", path);
        }

        // 이때 openFile1 과는 달리 finally 가 없음에도 불구하고 자동으로 호출된다.
    }
}
