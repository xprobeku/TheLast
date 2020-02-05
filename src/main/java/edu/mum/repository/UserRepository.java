package edu.mum.repository;

import edu.mum.domain.Role;
import edu.mum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	Optional<User> findById(Long id);
	// Demo usage of custom query
	@Query("SELECT u FROM User u WHERE (u.userName  = 'admin')")
	User findAdmin();

	List<User> findByRolesIsIn(List<Role> roles);

	List<User> findByRoles(Role role);

	List<User> findAll();

	Boolean findByUserNameIs(String userName);

	Boolean findByEmailIs(String userName);

	Boolean findByUserNameIsAndPasswordIs(String userName, String password);
	@Query("SELECT u.password FROM User u WHERE u.userName = :userName")
	String findPasswordByUserName(@Param("userName") String userName);
}
