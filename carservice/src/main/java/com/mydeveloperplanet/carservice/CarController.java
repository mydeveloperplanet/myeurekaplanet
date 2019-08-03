package com.mydeveloperplanet.carservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    private static final ArrayList<Car> carsDb = new ArrayList<Car>();

    static {

        carsDb.add(new Car("Renault", "Clio"));
        carsDb.add(new Car("Renault", "Kadjar"));
        carsDb.add(new Car("Ford", "Mondeo"));
        carsDb.add(new Car("Ford", "Mustang"));
    }

    @RequestMapping(value= "/getCars/{brand}", method = RequestMethod.GET)
    public List<Car> getCars(@PathVariable String brand) {

        System.out.println("Retrieve Cars");

        ArrayList<Car> carsList = new ArrayList<Car>();
        for (Car car : carsDb) {
            if (brand.equalsIgnoreCase(car.getBrand())) {
                carsList.add(car);
            }
        }
        return carsList;
    }
}
