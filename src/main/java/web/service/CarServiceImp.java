package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {
    private static int CARS_COUNT;
    private List<Car> cars;

    public CarServiceImp() {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "Audi", 52642));
        cars.add(new Car(++CARS_COUNT, "Mercedes", 57127));
        cars.add(new Car(++CARS_COUNT, "Skoda", 9000));
        cars.add(new Car(++CARS_COUNT, "Volvo", 29000));
        cars.add(new Car(++CARS_COUNT, "Bentley", 35000));
    }

    public List<Car> getCars(int count) {
        return cars.subList(0, count);
    }
}
