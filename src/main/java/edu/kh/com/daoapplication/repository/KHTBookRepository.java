package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.entity.KHTBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KHTBookRepository extends JpaRepository<KHTBook, Long> {
    KHTBook findByTitle(String title);

    KHTBook findById(int id);
}
