package edu.mum.repository;

import edu.mum.domain.Rental;
import edu.mum.domain.Tag;
import edu.mum.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
}
