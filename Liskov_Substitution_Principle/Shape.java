/*The Liskov Substitution Principle (LSP) states that objects of a superclass 
should be replaceable with objects of its subclasses 
without affecting the correctness of the program. 
*/

// Superclass
public class Shape {
    protected int width;
    protected int height;

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

// Subclass Rectangle
public class Rectangle extends Shape {
    public Rectangle(int width, int height) {
        super(width, height);
    }
}

// Subclass Square
public class Square extends Shape {
    public Square(int sideLength) {
        super(sideLength, sideLength);
    }
}

public class AreaCalculator {
    public int calculateArea(Shape shape) {
        return shape.getArea();
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(5);

        AreaCalculator calculator = new AreaCalculator();

        int areaOfRectangle = calculator.calculateArea(rectangle);
        int areaOfSquare = calculator.calculateArea(square);

        System.out.println("Area of Rectangle: " + areaOfRectangle); // Output: 50
        System.out.println("Area of Square: " + areaOfSquare); // Output: 25
    }
}
