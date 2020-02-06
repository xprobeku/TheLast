package edu.mum.repository;

import edu.mum.domain.Car;
import edu.mum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // TODO 8 : return car list filter by carBrand, model, price etc...
    @Query("SELECT c FROM Car c WHERE (c.carBrand   = :searchvalue or c.model   = :searchvalue  or c.price   = :searchvalue)")
    List<Car> findCars(@Param("searchvalue") String searchvalue);

}
