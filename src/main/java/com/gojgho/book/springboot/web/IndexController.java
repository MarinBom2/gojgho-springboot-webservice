package com.gojgho.book.springboot.web;


import com.gojgho.book.springboot.config.auth.LoginUser;
import com.gojgho.book.springboot.config.auth.dto.SessionUser;
import com.gojgho.book.springboot.domain.user.UserRepository;
import com.gojgho.book.springboot.service.PostsService;
import com.gojgho.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    private final HttpSession httpSession;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) //1
    {
        model.addAttribute("posts",postsService.findAllDesc());


        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userPicture",user.getPicture());
            model.addAttribute("userEmail",user.getEmail());
        }
        return "index";
    }


    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){

        if(user != null){
            model.addAttribute("userName",user.getName());
            model.addAttribute("userPicture",user.getPicture());
            model.addAttribute("userEmail",user.getEmail());
        }

        return "posts-save";  //posts/save를 호출하면 posts-save.mustache 파일 호출하는 메소드가 추가 됨
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
