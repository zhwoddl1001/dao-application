package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.entity.KHTBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KHTBookRepository extends JpaRepository<KHTBook, Long> {
    // save
    // findAll
    //-> 기존에 JPA에서 만들었던 save 메서드를 변형해서 재설정
    // KHTBook save(String title, String author, String genre, String imagePath);
    KHTBook findById(int id);
}