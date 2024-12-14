package Task14;

public enum TrafficLight {
    RED("GREEN"),
    YELLOW("RED"),
    GREEN("YELLOW");

    private final String nextColor;

    TrafficLight(String nextColor){
        this.nextColor = nextColor;
    }

    public String getNextColor() {
        return nextColor;
    }

    @Override
    public String toString() {
        return "Следующий сигнал: " + nextColor;
    }
}
