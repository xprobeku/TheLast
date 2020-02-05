package edu.mum.repository;

import edu.mum.domain.Rental;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
	List<Rental> findByCarOwnerId(long userId);
	List<Rental> findByUserUserNameContainingOrCarModelContaining(String user_userName, String car_model);
	List<Rental> findByUserId(long userId);
}
