package playground.inheritance;

/**
 * Created by jtse on 11/23/16.
 */
public class Truck extends Car {
    boolean tall = true;

    public boolean isTall() {
        return tall;
    }

    @Override
    public String toString() {
        return "Truck";
    }
}
