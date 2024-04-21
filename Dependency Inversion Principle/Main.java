/*
The Dependency Inversion Principle (DIP) is one of the SOLID 
principles of object-oriented programming. It suggests that
high-level modules/classes should not depend on low-level modules/classes,
but rather both should depend on abstractions. This principle encourages
the decoupling of software modules by ensuring that 
they depend on abstractions rather than concrete implementations.
*/

// Abstraction
interface Switch {
    boolean isEnabled();
    void turnOn();
    void turnOff();
}

// High-level module depending on abstraction
class LightSwitch {
    private final Switch light;

    public LightSwitch(Switch light) {
        this.light = light;
    }

    public void turnOn() {
        if (!light.isEnabled()) {
            light.turnOn();
        }
    }

    public void turnOff() {
        if (light.isEnabled()) {
            light.turnOff();
        }
    }
}

// Low-level module
class LightBulb implements Switch {
    private boolean isEnabled;

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void turnOn() {
        isEnabled = true;
        System.out.println("Light is on");
    }

    @Override
    public void turnOff() {
        isEnabled = false;
        System.out.println("Light is off");
    }
}

// Low-level module
class Fan implements Switch {
    private boolean isEnabled;

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void turnOn() {
        isEnabled = true;
        System.out.println("Fan is on");
    }

    @Override
    public void turnOff() {
        isEnabled = false;
        System.out.println("Fan is off");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using dependency inversion principle
        Switch light = new LightBulb(); // Instead of directly using LightBulb, we use Switch
        Switch fan = new Fan(); // Instead of directly using Fan, we use Switch

        LightSwitch lightSwitch = new LightSwitch(light);
        LightSwitch fanSwitch = new LightSwitch(fan);

        lightSwitch.turnOn(); // Output: Light is on
        lightSwitch.turnOff(); // Output: Light is off

        fanSwitch.turnOn(); // Output: Fan is on
        fanSwitch.turnOff(); // Output: Fan is off
    }
}
