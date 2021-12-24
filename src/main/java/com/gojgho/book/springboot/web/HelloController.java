package com.gojgho.book.springboot.web;

import com.gojgho.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //1 컨트롤러를 json을 반환하는 컨트롤러로 만들어줌 예전 @ResponseBody 를 각메소드마다 선언했던것을 한번에 사용할수있게해줌
public class HelloController {
    //예전에는 @RequesetMapping(method = RequestMethod.GET) 으로 사용되었음
    @GetMapping("/hello") //2 http method인 get의 요청을 받을수있는 api를 만들어줌
        public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){

        return new HelloResponseDto(name,amount);
    }

    // RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 // 이 메소드 파라미터를 name(String name)에 저장하게됨
}





