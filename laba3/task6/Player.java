package task6;

public abstract class Player {
    protected String name;
    protected int health;
    protected int max_health;
    protected int posX;
    protected int posY;
    protected boolean isAlife = true;
    protected int defence;
    protected int attakPower;
    protected int healPower;
    protected Race race;

    public Player(String name, int health, int max_health, Race race){
        this.name = name;
        this.health = health;
        this.max_health = max_health;
        this.isAlife = true;
        this.posX = 0;
        this.posY = 0;
        this.race = race;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void String (){
        this.name = name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getMax_health(){
        return max_health;
    }

    public void setMax_health(int max_health){
        this.max_health = max_health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttakPower() {
        return attakPower;
    }

    public void setAttakPower(int attakPower) {
        this.attakPower = attakPower;
    }

    public int getHealPower(){
        return healPower;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    public boolean getIsAlife() {
        return isAlife;
    }

    public void setAlife(boolean alife) {
        isAlife = alife;
    }

    public void increaseHealth(int value) {
        if (isAlife) {
            health = Math.min(max_health, health + value);
        }
    }

    public void decreaseHealth(int value) {
        if (isAlife) {
            health = health + defence - value;
            if (health <= 0) {
                isAlife = false;
                health = 0;
                System.out.println(name + " погиб.");
            }
        }
    }

    public void move(int x, int y) {
        posX = x;
        posY = y;
        System.out.println(name + " переместился на позицию (" + posX + ", " + posY + ").");
    }

    public int getDistanceTo(Player other) {
        return Math.abs(this.posX - other.posX) + Math.abs(this.posY - other.posY);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", " + race + ", Здоровье: " + health + "/" + max_health + ", Статус: " + (isAlife ? "Жив" : "Мертв") + ", Позиция x: " + posX + ", Позиция y: " + posY;
    }
}
