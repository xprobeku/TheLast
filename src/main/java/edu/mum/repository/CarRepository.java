package edu.mum.repository;

import edu.mum.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByOwnerId(long userId);
    Car getById(long id);
    List<Car> findAllByCarBrandContainingOrModelContainingOrDescriptionContainingOrderByDescription(
            String carBrand,
            String model,
            String description
    );
    List<Car> findAllByPriceEquals(Double price);
    List<Car> findAllBySeatsEqualsOrYearEquals(Integer seats, Integer year);

}
