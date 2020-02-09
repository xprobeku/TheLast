package edu.mum.service;


import edu.mum.domain.Rental;
import edu.mum.domain.User;

import java.util.List;

public interface RentalService {

    List<Rental> searchRental(String searchString);

    List<Rental> getRentalsByUser(long userId);

    List<Rental> getAll();

    List<Rental> getByCarOwner(long ownerId);

    List<Rental> getByUser(long userId);

    void createRental(Rental rental, Long carId, User user);

    void rentalApprove(long rentalId);

    void rentalFinish(long rentalId);

    void rentalReject(long rentalId, String rejectDesc);
}
