package playground.inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtse on 11/23/16.
 */
public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car());
        cars.add(new Limo());
        cars.add(new Truck());

        print(cars);


        List<Truck> trucks = new ArrayList<>();

        trucks.add(new Truck());
        trucks.add(new Truck());
        trucks.add(new Truck());
        trucks.add(new Truck());

        print(trucks);

        List<Limo> limos = new ArrayList<>();
        limos.add(new Limo());
        limos.add(new Limo());
        limos.add(new Limo());
        limos.add(new Limo());

        print(limos);
    }

    private static void print(List<? extends Car> cars) {
        for (Car c : cars) {
            System.out.println(c);
        }
    }
}
