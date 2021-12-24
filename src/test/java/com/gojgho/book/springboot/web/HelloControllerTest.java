package com.gojgho.book.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) //1.테스트를 진행할떄 JUnit에 내장된 실행자 외에 다른 실행자 실행 즉 스프링 부트와 Junit사이에 연결자 역활
@WebMvcTest(controllers = HelloController.class,secure = false) //2 여러 스프링 어노테이션 중 Web(spring MVC)에 집중할수있는 어노테이션
// 2 선언시 @Controller, ControllerAdive 사용 //
public class HelloControllerTest {

    @Autowired //3 스프링이 관리하는 빈(Bean)을 주입받는다.
    private MockMvc mvc; //4 웹 API 테스트 할떄 사용 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //5 Mock mvc 를 통해 /hello 주소로 http get 요청을 한다 .
              .andExpect(status().isOk()) //6 mvc.perform의 결과를 검증 200,404,500 등
                .andExpect(content().string(hello)); //7 controller 에서 hello 를 리턴하기때문에 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name  = "hello";
        int amount = 1000;
        //1 param API에 사용될 요청 파라미터를 설정 단, 값은 String만 숫자/날짜 등 데이터 등록도 문자열로 변경
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))   //2 jsonPath JSON 응답값을 필드별로 검증 메소드 $기준으로 필드명 검사
                .andExpect(jsonPath("$.amount",is(amount)));
    }

}
