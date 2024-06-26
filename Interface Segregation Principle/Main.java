/*The Interface Segregation Principle (ISP) states that a 
client should not be forced to implement an interface that it doesn't use.
Instead of one large interface, clients should have specific interfaces to adhere to. 

*/

// The Worker interface represents a worker
/*
interface Worker {
    void work();
    void eat();
}
*/
interface Worker {
    void work();
}
interface Eater {
    void eat();
}


// The Robot class represents a robot worker
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        // Robots don't eat
        System.out.println("Robot doesn't need to eat");
    }
}

// The Human class represents a human worker
class Human implements Worker, Eater {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }

}

public class Main {
    public static void main(String[] args) {
        // Creating a robot
        Worker robot = new Robot();
        robot.work();
        robot.eat(); // Output: Robot doesn't need to eat

        // Creating a human
        WorkerWithBreak humanWithBreak = new Human();
        humanWithBreak.work();
        humanWithBreak.eat();
        ((WorkerWithBreak) humanWithBreak).takeBreak(); // Output: Human is taking a break

        WorkerWithBonus humanWithBonus = new Human();
        humanWithBonus.work();
        humanWithBonus.eat();
        ((WorkerWithBonus) humanWithBonus).receiveBonus(500.0); // Output: Human received a bonus of $500.0
    }
}
