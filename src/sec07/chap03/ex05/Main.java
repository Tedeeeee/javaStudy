package src.sec07.chap03.ex05;

public class Main {
    public static void main(String[] args) {

        // 아무나 탈수 있는 말
        Horse<Unit> avante = new Horse<>();
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        // 기사 계급 이상을 태우는 말
        Horse<Knight> sonata = new Horse<>();
        // Unit 은 Knight 보다 더 큰 상위 클래스가 된다. 때문에 Unit 은 Knight 를 품을 수 있어도 Knight 는 Unit 을 품을 수 없다.
        // sonata.setRider(new Unit());
        sonata.setRider(new Knight());
        sonata.setRider(new MagicKnight());

        // 마법사만 탈 수 있는 말
        Horse<MagicKnight> grandeur = new Horse<>();
        // 위와 같은 이유로 탑승 불가
        // grandeur.setRider(new Unit());
        // grandeur.setRider(new Knight());
        grandeur.setRider(new MagicKnight());

        // 자료형과 제네릭 타입이 일치하지 않으면 대입도 불가능 하다
        // Horse<Unit> wrongHorse1 = new Horse<Knight>();
        // Horse<Knight> wrongHorse2 = new Horse<Unit>();

        // avante = sonata;
        // sonata = grandeur;


        //  ⭐️ 와일드카드 - 제네릭 타입의 다형성을 위함
        // Knight 와 그 자식 클래스만 받을 수 있다.
        Horse<? extends Knight> knightHorse;
        // knightHorse = new Horse<Unit>(); // ⚠️ 불가
        knightHorse = new Horse<Knight>();
        knightHorse = new Horse<MagicKnight>();
        // knightHorse = avante; // ⚠️ 불가
        knightHorse = sonata;
        knightHorse = grandeur;

        // knight 와 그의 조상만 받을수 있다.
        Horse <? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;
        // nonLuxuryHorse = grandeur;

        // 그냥 ? 만 있으면 그 무엇이든 가능하다.
        // <? extends Object> 와 같은 말이다.
        Horse<?> anyHorse;
        anyHorse = avante;
        anyHorse = sonata;
        anyHorse = grandeur;

        HorseShop.intoBestSellers(avante);
        HorseShop.intoBestSellers(sonata);
        HorseShop.intoBestSellers(grandeur);

        // Unit 은 해당사항이 없다
        // HorseShop.intoPremiums(avante);
        HorseShop.intoPremiums(sonata);
        HorseShop.intoPremiums(grandeur);

        HorseShop.intoEntryLevels(avante);
        HorseShop.intoEntryLevels(sonata);
        // MaigicHorse 는 해당사항에 없다
        // HorseShop.intoEntryLevels(grandeur);


        //  ⭐️ 제네릭은 변수에 들어올 값에 대한 제한
        Horse[] horses = {avante, sonata, grandeur};
        for (Horse horse : horses) {
            horse.setRider(new Unit());
        }

    }
}
