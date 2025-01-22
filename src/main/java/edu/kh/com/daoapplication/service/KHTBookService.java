package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.entity.KHTBook;
import edu.kh.com.daoapplication.repository.KHTBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHTBookService {
    @Autowired
    private KHTBookRepository khtBookRepository;
    
    // 모든 책 조회
    public List<KHTBook> findAll() {
        return khtBookRepository.findAll();
    }
    // 책 등록
    public KHTBook save(KHTBook khtBook) {
        return khtBookRepository.save(khtBook);
    }
    // 책 상세보기
    public KHTBook findById(int id) {
        return khtBookRepository.findById(id);
    }
}
