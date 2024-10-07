package task6;

class Race {
    private String raceName;
    private int attackBonus;
    private int defenseBonus;
    private int healBonus;
    private int spellBonus;

    public Race(String raceName, int attackBonus, int defenseBonus, int healBonus, int spellBonus) {
        this.raceName = raceName;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healBonus = healBonus;
        this.spellBonus = spellBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getHealBonus() {
        return healBonus;
    }

    public int getSpellBonus() {
        return spellBonus;
    }

    @Override
    public String toString() {
        return "Раса: " + raceName;
    }
}
