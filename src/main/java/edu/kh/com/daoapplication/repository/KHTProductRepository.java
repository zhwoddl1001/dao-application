package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.model.entity.KHTProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface KHTProductRepository extends JpaRepository<KHTProduct, Long> {
    KHTProduct findByName(String name);

    KHTProduct findById(int id);
}
