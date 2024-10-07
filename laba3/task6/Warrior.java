package task6;

public class Warrior extends Player{
    protected int attackRange;

    public Warrior(String name, int health, int max_health, int attakPower, Race race, int attackRange){
        super(name, health, max_health, race);
        this.attakPower = attakPower;
        this.attackRange = attackRange;
    }

    void attak(Player target) {
        if (isAlife){
            if (target.isAlife) {
                int distance = getDistanceTo(target);
                if (distance <= attackRange) {
                    int effectiveAttackPower = attakPower + race.getAttackBonus();
                    System.out.println(name + " атакует " + target.name + " с расстояния " + distance);
                    target.decreaseHealth(effectiveAttackPower);
                } else {
                    System.out.println(name + " не может атаковать " + target.name + " — слишком далеко!");
                }
            } else {
                System.out.println("Выбранный для битья персонаж мёртв.");
            }
        }
    }
}
