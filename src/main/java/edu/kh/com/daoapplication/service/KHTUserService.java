package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.model.entity.KHTUser;
import edu.kh.com.daoapplication.repository.KHTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class KHTUserService {
    @Autowired
    private KHTUserRepository khtUserRepository;
    
    @Autowired // @Bean 이나 @Bean이 내장되어있는 @Mapper @Repository @Controller @Service 등 호출하는 기능
    private PasswordEncoder passwordEncoder; // SecurityConfig.java 내부에 작성되어있는 기능 가져옴

    @Value("${upload-img}") //application.properties 에 작성한 이미지 경로 가져옴
    private String uploadImg; //가져온 경로는 uploadImg 공간 안에 담아줌

    public KHTUser save(String username, String password, MultipartFile file) {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

//                                  경로 + 파일명칭
        try {
            File saveFile = new File(uploadImg, filename);
            // 1. 이미지 저장하기
            file.transferTo(saveFile);
        } catch (IOException e) {
            System.out.println("이미지 저장 실패!");
        }
        KHTUser khtUser = new KHTUser();
        khtUser.setUsername(username);
        khtUser.setPassword(passwordEncoder.encode(password));
        khtUser.setImagePath("/images/" + filename);
        return khtUserRepository.save(khtUser);
    }


    // 모든 유저 조회
    public List<KHTUser> findAll() {
        
        return khtUserRepository.findAll();
    }

    // 유저 저장하기
    /*
    public KHTUser save(KHTUser khtUser) {
        // khtUser.getPassword() = khtUser 유저에 저장하고자 사용자가 html 에서 작성한 비밀번호 가져오기
        // passwordEncoder.encode(khtUser.getPassword()) = 가져온 비밀번호 암호화
        //  khtUser.setPassword() = 암호화된 비밀번호를 DB에 저장
        System.out.println("html -> controller -> service로 가져온 비밀번호 확인 : "+ khtUser.getPassword());


        khtUser.setPassword(passwordEncoder.encode(khtUser.getPassword()));
        System.out.println(("암호화 완료된 비밀번호 확인 : " + khtUser.getPassword()));
        return khtUserRepository.save(khtUser);
    }
    */

    // 아이디를 활용해서 유저 상세보기
    public KHTUser findById(int id) {
        return khtUserRepository.findById(id);
    }


}
