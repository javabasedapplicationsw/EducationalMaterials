package com.hillstate.penthouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/list")
    //@ResponseBody
    public String index() {
        return "questionlist";          // questionlist라는 템플릿에 저장된 내용을 브라우저 화면에 전달함
    }
}
