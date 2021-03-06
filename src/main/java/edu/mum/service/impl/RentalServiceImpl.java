package edu.mum.service.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Car;
import edu.mum.domain.Rental;
import edu.mum.domain.RentalStatus;
import edu.mum.domain.User;
import edu.mum.repository.RentalRepository;
import edu.mum.service.CarService;
import edu.mum.service.RentalService;
import edu.mum.service.UserService;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CarService carService;

    @Autowired
    UserService userService;

    @Override
    public List<Rental> searchRental(String searchString) {
        return rentalRepository.findByUserUserNameContainingOrCarModelContaining(searchString, searchString);
    }

    @Override
    public List<Rental> getRentalsByUser(long userId) {
        return rentalRepository.findByUserId(userId);
    }

    @Override
    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }

    @Override
    public List<Rental> getByCarOwner(long ownerId) {
        return rentalRepository.findByCarOwnerId(ownerId);
    }

    @Override
    public List<Rental> getByUser(long userId) {
        return rentalRepository.findByUserId(userId);
    }

    @Override
    public void createRental(Rental rental, Long carId, User user) {

        Car car = carService.getById(carId);
        if (car.getAvailable()) {
            car.setAvailable(false);
            carService.save(car);
            rental.setCreateDate(new Date());
            rental.setApprovalDate(new Date());
            rental.setPickUpDate(new Date());
            rental.setReturnDate(new Date());
            rental.setCar(car);
            rental.setUser(user);
            rental.setStatus(RentalStatus.PENDING);
            rentalRepository.save(rental);
        }

    }

    @Override
    public void rentalApprove(long rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setApprovalDate(new Date());
        rental.setStatus(RentalStatus.APPROVED);
        rentalRepository.save(rental);
    }

    @Override
    public void rentalFinish(long rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        setCarAvilablity(rental, true);
        rental.setReturnDate(new Date());
        rental.setStatus(RentalStatus.RETURNED);
        rentalRepository.save(rental);
    }

    @Override
    public void rentalReject(long rentalId, String rejectDesc) {
        Rental rental = rentalRepository.findOne(rentalId);
        setCarAvilablity(rental, true);
        rental.setDeclinedDate(new Date());
        rental.setDeclineDesc(rejectDesc);
        rental.setStatus(RentalStatus.DECLINED);
        rentalRepository.save(rental);
    }

    void setCarAvilablity(Rental rental, Boolean status) {
        Car car = rental.getCar();
        car.setAvailable(status);
        carService.updateCar(car);
    }
}

