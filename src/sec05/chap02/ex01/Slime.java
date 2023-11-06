package src.sec05.chap02.ex01;

public class Slime {
    double hp = 50;
    int attack = 8;
    double defense = 0.2;

    void attack(Slime enemy) {
        enemy.hp -= attack * (1 - enemy.defense);
    }
}
