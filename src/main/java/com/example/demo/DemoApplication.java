package com.example.demo;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRepository;
import com.example.demo.domain.Owner;
import com.example.demo.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    private final CarRepository repository;
    private final OwnerRepository ownerRepository;

    public DemoApplication(CarRepository repository, OwnerRepository ownerRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        Owner owner1 = new Owner("Victoria", "Kim");
        Owner owner2 = new Owner("Vladislav", "Pak");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        repository.save(new Car("KIA", "K5", "Black", "ADF-1121", 2023, 59000, owner1));
        repository.save(new Car("Hyundai", "Tucson", "White", "SSJ-3002", 2020, 29000, owner2));
        repository.save(new Car("Li", "L9", "Silver", "KKO-0212", 2022, 39000, owner2));

        repository.findAll().forEach(car ->
                log.info("brand: {}, model: {}, owner: {}",
                        car.getBrand(),
                        car.getModel(),
                        car.getOwner() != null ? car.getOwner().getFirstname() : "no owner")
        );
    }
}