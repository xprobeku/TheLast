package edu.mum.service.impl;


import edu.mum.domain.Rental;
import edu.mum.domain.RentalStatus;
import edu.mum.repository.RentalRepository;
import edu.mum.service.CarService;
import edu.mum.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CarService carService;

    @Override
    public List<Rental> searchRental(String searchString) {
        return rentalRepository.findByUserUserNameContainingOrCarModelContaining(searchString,searchString);
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
    public void createRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public void rentalApprove(long rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setApprovalDate(LocalDate.now());
        rental.setStatus(RentalStatus.APPROVED);
        rentalRepository.save(rental);
    }

    @Override
    public void rentalFinish(long rentalId) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setReturnDate(LocalDate.now());
        rental.setStatus(RentalStatus.RETURNED);
        rentalRepository.save(rental);
    }

    @Override
    public void rentalReject(long rentalId, String rejectDesc) {
        Rental rental = rentalRepository.findOne(rentalId);
        rental.setDeclinedDate(LocalDate.now());
        rental.setDeclineDesc(rejectDesc);
        rental.setStatus(RentalStatus.DECLINED);
        rentalRepository.save(rental);
    }
}

