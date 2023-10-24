package src.sec03.chap01;

public class Ex05 {
    public static void main(String[] args) {
        int a = 1;
        a = a + 2;

        a += 3; // 🔴

        // 값을 반환하기도 함
        int b = a += 4; // 🔴

        //  💡 추가
        //  - 일반 대입 연산자도 값을 반환함

        int i1 = 0;
        int i2 = 1;
        int i3 = (i1 = i2); // 괄호 제거해도 같음

        String s1 = "ABC";
        String s2 = "가나다";
        String s3 = (s1 = s2);

        double db = (double) 5 / 2;

        String[] intFormats = {
                "%d",        // 1. 기본
                "%13d",      // 2. n 자리수 확보, 오른쪽 정렬
                "%013d",     // 3. 빈 자리수 0으로 채움
                "%+13d",     // 4. 양수는 앞에 + 붙임
                "%,13d",     // 5. 쉼표 사용
                "%-13d",     // 6. 자리수 확보, 왼쪽 정렬
                "%+,013d"    // 7.
        };

        String[] intResults = new String[intFormats.length];

        // 이후의 배울 for 반복문
        // - 위의 형식들로 하나하나 출력해보는 코드
        for (var i = 0; i < intFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 4; j++) {
                format += intFormats[i] + " ";
            }
            format = format.trim() + "%n%n";  // "%d %d %d %d%n%n" ...
              System.out.println(format); // 🔍 주석해제하여 함께 확인

            //  🔍 이 숫자들을 스페이스로 구분해서 출력해 볼 것
            System.out.printf(format, 12, 2345, 67890, -1234567);

            //  ⭐️ formatted 메소드에서도 사용 가능
            intResults[i] = format.formatted(12, 2345, 67890, -1234567);
        }
    }

}
