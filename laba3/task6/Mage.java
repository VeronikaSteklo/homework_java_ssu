package task6;

public class Mage extends Player{

    public Mage(String name, int health, int max_health, int attakPower, Race race){
        super(name, health, max_health, race);
        this.attakPower = attakPower;
    }

    public void castSpell(Player target) {
        if (isAlife){
            if (target.isAlife) {
                System.out.println(name + " кастует заклинание на " + target.name);
                target.decreaseHealth(attakPower + race.getSpellBonus());
            } else {
                System.out.println("Выбранный для битья персонаж мёртв.");
            }
        }
    }
}
