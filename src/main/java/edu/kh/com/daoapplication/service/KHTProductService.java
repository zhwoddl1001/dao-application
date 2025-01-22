package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.entity.KHTProduct;
import edu.kh.com.daoapplication.repository.KHTProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class KHTProductService {
    @Autowired
    private KHTProductRepository khtProductRepository;

    public List<KHTProduct> findAll() {
        return khtProductRepository.findAll();
    }

    public KHTProduct save(KHTProduct khtProduct) { // 저장할거를 () 안에 씀
        return khtProductRepository.save(khtProduct);
    }

    public KHTProduct findById(int id) {
        return khtProductRepository.findById(id);
    }

 }

