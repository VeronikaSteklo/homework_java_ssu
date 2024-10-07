package task6;

public class Priest extends Player{

    private int healPower;
    public Priest(String name, int health, int max_health, int healPower, Race race){
        super(name, health, max_health, race);
        this.healPower = healPower;
    }

    void heal(Player target) {
        if (isAlife){
            if (target.isAlife) {
                System.out.println(name + " лечит " + target.name);
                target.increaseHealth(healPower + race.getHealBonus());
            } else {
                System.out.println("Выбранный для лечения персонаж мёртв.");
            }
        }
    }
}
