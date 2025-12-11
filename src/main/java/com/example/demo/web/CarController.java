package com.example.demo.web;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarRepository repo;

    public CarController(CarRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public Iterable<Car> getCars() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return repo.save(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}