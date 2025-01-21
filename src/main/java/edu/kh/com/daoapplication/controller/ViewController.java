package edu.kh.com.daoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/product")
    public String getProduct(){
        return "product";
    }

    /**
     * @Requesr=요청해서가져옴 Param = 매개변수, 파라미터에 해당하는 ("id")값을
     *                      ? 물음표 뒤에 오는 키=값 형태로 값을 가져옴
     *                      /user?id=아이디에 해당하는 값을 가져와서
     *                      /user?id=1 번호로 이동
     *
     * @param id 는 userDetail(유저상세보기) 페이지에
     *              유저 번호로 해당하는 유저 상세정보를
     * @return      userDetail.html 에서 번호에 해당하는 유저를 볼 수 있도록 설정하는 parameter
     */
    @GetMapping("/user")
    public String getUser(@RequestParam("id")int id){ // @RequestParam("id")int id 번호별로 해서 페이지를 보여주기 위함
        return "userDetail";
    }
    @GetMapping("/products/detail")
    public String getProductDetail(@RequestParam("id")int id){
        return "productDetail";
    }
}
