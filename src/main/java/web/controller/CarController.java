package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    private final CarServiceImp carService;

    @Autowired
    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(required = false, defaultValue = "5") String count, ModelMap model) {
        int countInt;
        try {
            countInt = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            countInt = 5;
        }
        if (countInt < 1 || countInt > 5) {
            countInt = 5;
        }
        List<Car> cars = carService.getCars(countInt);
        model.addAttribute("cars", cars);
        return "cars/index";
    }
}
