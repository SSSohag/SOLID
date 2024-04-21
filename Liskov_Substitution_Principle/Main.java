/*The Liskov Substitution Principle (LSP) states that objects of a superclass 
should be replaceable with objects of its subclasses 
without affecting the correctness of the program. 
*/

// The Shape interface represents a shape
interface Shape {
    double calculateArea();
}

// The Quadrilateral class represents a quadrilateral
class Quadrilateral implements Shape {
    private double width;
    private double height;

    // Constructor
    public Quadrilateral(double width, double height) {
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

    // Implementation of calculateArea method for Quadrilateral
    @Override
    public double calculateArea() {
        return width * height;
    }
}

// The Square class represents a square
class Square implements Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Getters and setters
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // Implementation of calculateArea method for Square
    @Override
    public double calculateArea() {
        return side * side;
    }
}

// The AreaCalculator class is responsible for calculating the total area of shapes
class AreaCalculator {
    // Method to calculate the total area of a list of shapes
    public double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating shapes
        Shape rectangle = new Quadrilateral(5, 4);
        Shape square = new Square(3);

        // Creating an array of shapes
        Shape[] shapes = new Shape[]{rectangle, square};

        // Calculating total area of shapes
        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area of shapes: " + totalArea);
    }
}
