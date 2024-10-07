package task6;

public class Main {
    public static void main(String[] args) {
        Race orc = new Race("Орк", 5, 10, 0, 0);
        Race elf = new Race("Эльф", 0, 5, 5, 10);
        Race human = new Race("Человек", 2, 3, 2, 2);

        Warrior warrior = new Warrior("Леви", 72, 72, 20, orc, 5);
        Mage mage = new Mage("Эрен", 90, 90, 18, elf);
        Priest priest = new Priest("Микаса", 100, 100, 19, elf);
        WarriorGuard guard = new WarriorGuard("Армин", 150, 150, 1, 5, human, 7);

        mage.castSpell(warrior);
        warrior.attak(mage);
        priest.heal(mage);
        warrior.attak(guard);
        warrior.move(10, 10);
        guard.move(-10, -10);

        warrior.attak(mage);
        guard.attak(mage);

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println(guard);
    }

}
