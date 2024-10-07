package org.example.Task4;

public class Container {
    private double totalVolume;
    private double usedVolume = 0;

    public Container(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public void add(Shape shape) {
        double shapeVolume = shape.getVolume(); 

        if (shapeVolume <= getRemainingVolume()) {
            usedVolume += shapeVolume;
            System.out.println("Фигура добавлена. Оставшийся объём: " + getRemainingVolume());
        } else {
            System.out.println("Недостаточно места для добавления фигуры. Оставшийся объём: " + getRemainingVolume());
        }
    }

    public double getRemainingVolume() {
        return totalVolume - usedVolume;
    }
}
