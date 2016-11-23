package playground.inheritance;

/**
 * Created by jtse on 11/23/16.
 */
public class Limo extends Car {
    boolean mLong = true;

    public boolean isLong() {
        return mLong;
    }

    @Override
    public String toString() {
        return "Limo";
    }
}
