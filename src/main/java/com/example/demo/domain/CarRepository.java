package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(@Param("brand") String brand);
    List<Car> findByColor(@Param("color") String color);
    List<Car> findByModelYear(@Param("modelYear") int modelYear);
    List<Car> findByBrandAndColor(@Param("brand") String brand,
                                  @Param("color") String color);

}