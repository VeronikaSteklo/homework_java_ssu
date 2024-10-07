package task6;

class WarriorGuard extends Warrior {
    private int additionalDefense;


    public WarriorGuard(String name, int health, int max_health, int attakPower, int additionalDefense, Race race, int attackRange) {
        super(name, health, max_health, attakPower, race, attackRange);
        this.additionalDefense = additionalDefense;
    }

    @Override
    public void decreaseHealth(int value) {
        if (isAlife) {
            health = health + defence + additionalDefense - value + race.getDefenseBonus();
            if (health <= 0) {
                isAlife = false;
                health = 0;
                System.out.println(name + " погиб.");
            }
        }
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
