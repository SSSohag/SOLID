/*The Open/Closed Principle (OCP) states that a class should 
be open for extension but closed for modification.
This means that the behavior of a class should be extendable without 
modifying its source code*/


import java.util.ArrayList;
import java.util.List;

// The Shape interface represents a shape
interface Shape {
    double calculateArea();
}

// The Rectangle class represents a rectangle
class Rectangle implements Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Implementation of calculateArea method for Rectangle
    @Override
    public double calculateArea() {
        return width * height;
    }
}

// The Circle class represents a circle
class Circle implements Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Implementation of calculateArea method for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// The AreaCalculator class is responsible for calculating the total area of shapes
class AreaCalculator {
    // Method to calculate the total area of a list of shapes
    public double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

public class Test {
    public static void main(String[] args) {
        // Creating shapes
        Shape rectangle = new Rectangle(5, 4);
        Shape circle = new Circle(3);

        // Creating a list of shapes
        List<Shape> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(circle);

        // Calculating total area of shapes
        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area of shapes: " + totalArea);
    }
}
