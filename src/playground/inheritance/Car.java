package playground.inheritance;

/**
 * Created by jtse on 11/23/16.
 */
public class Car {
    protected int wheels = 4;

    public int getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "Car";
    }
}
