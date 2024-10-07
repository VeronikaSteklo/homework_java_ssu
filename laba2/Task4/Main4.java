package org.example.Task4;

public class Main4 {
    public static void main(String[] args) {
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(3);
        Shape cylinder = new Cylinder(2, 10);

        container.add(sphere);
        container.add(cube);
        container.add(cylinder);
    }
}
