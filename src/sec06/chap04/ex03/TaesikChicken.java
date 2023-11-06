package src.sec06.chap04.ex03;

public class TaesikChicken {
    static TaesikChickenMenu[] menus = TaesikChickenMenu.values();

    public void takeOrder(String menuName) {
        TaesikChickenMenu ordered = null;

        for (var menu : menus) {
            if (menu.getName().equals(menuName)) {
                ordered = menu;
            }
        }

        if (ordered == null) {
            System.out.println("해당 메뉴는 저희 가게에 없습니다");
            return;
        }

        System.out.println(ordered.getPrice() + " 원입니다");

    }
}
