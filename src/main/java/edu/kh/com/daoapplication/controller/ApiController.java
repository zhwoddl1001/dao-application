package edu.kh.com.daoapplication.controller;

import edu.kh.com.daoapplication.entity.KHTBook;
import edu.kh.com.daoapplication.entity.KHTProduct;
import edu.kh.com.daoapplication.entity.KHTUser;
import edu.kh.com.daoapplication.service.KHTBookService;
import edu.kh.com.daoapplication.service.KHTProductService;
import edu.kh.com.daoapplication.service.KHTUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api") // 맨 앞에 공통으로 들어갈 url api 명칭 작성

public class ApiController {

    @Autowired
    private KHTUserService khtUserService;
    @Autowired
    private KHTProductService khtProductService;

    @Autowired
    private KHTBookService khtBookService;
    
    // ajax url 을 이용해서 DB에 저장된 DB 불러오기
    @GetMapping("/users")
    public List<KHTUser> findAll() {
        List<KHTUser> users = khtUserService.findAll();
        log.info(users.toString());
        return users;
    }
    // ajax url을 이용해서 DB에 회원 저장하기
    @PostMapping("/saveUser") // /api/savUser
    public KHTUser saveUser(@RequestBody KHTUser khtUser) {
        return khtUserService.save(khtUser);
    }

    // 모든 제품 조회 /api/products
    @GetMapping("/products")
    public List<KHTProduct> findAllProducts() {
        List<KHTProduct> products = khtProductService.findAll();
        log.info(products.toString());
        return products;
    }

    // 제품 등록 /api/saveProduct
    @PostMapping("/saveProduct")
    public KHTProduct saveProduct(@RequestBody KHTProduct product) {
        KHTProduct savedProduct = khtProductService.save(product);
        log.info(savedProduct.toString());
        return savedProduct;
        //  return khtProductService.save(product);
    }

    /**
     * 
     *  @RequestParam 으로 전달받은 값을 
     * URLSearchParams = URL 주소에서 parameters(파라미터들)을 search 검색해서
     * urlParams 라는 변수 이름에 ? 뒤에 오는 키=값 을 모두 담아둠
     * urlParams 에서 원하는 키의 값을 GET 해서 가져옴
     * id 라는 변수 이름에 키에 해당하는 값을 저장
     *           
     *   const urlParams = new URLSearchParams(window.location.search);
     *   const id = urlParams.get('id');
     * @param id 는 get('id') 로 가져온 값을 활용해서 ajax로 DB에 id값에 해당하는 데이터를 가져오기
     * @return
     */ // 아이디로 상세보기
    @GetMapping("/user/{id}")
    public KHTUser findById(@PathVariable("id") int id) {
        KHTUser khtUser = khtUserService.findById(id);
        log.info(khtUser.toString());
        return khtUser; // 가져온 데이터가 있든 없든 html에 전달
    }
    
    // 아이디로 제품 상세보기
    @GetMapping("/products/{id}")
    public KHTProduct findByID(@PathVariable("id") int id) {
        KHTProduct khtProduct = khtProductService.findById(id);
        log.info(khtProduct.toString());
        return khtProduct;
    }

     @GetMapping("/books")
    public List<KHTBook> findAllBooks() {
        List<KHTBook> books = khtBookService.findAll();
        log.info(books.toString());
        return books;
     }

    @GetMapping("/book/{id}")
    public KHTBook findByBookId(@PathVariable("id")int id){
        KHTBook khtBook = khtBookService.findById(id);
        log.info(khtBook.toString());
        return khtBook;
    }
    // 405 (Method Not Allowed) GET 으로는 DB 저장 X
    // Request method 'POST'
    @PostMapping("/bookSave")
    public KHTBook saveBook(@RequestBody KHTBook book) {
        KHTBook savedBook = khtBookService.save(book);
        log.info(savedBook.toString());
        return savedBook;
    }
}
