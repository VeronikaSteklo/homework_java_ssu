package Task20;

public class Task20 {
    public static void main(String[] args){
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println(integerBox.sum()); // 30

        Box<Double> doubleBox = new Box<Double>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println(doubleBox.sum()); // 4.0
    }
}
