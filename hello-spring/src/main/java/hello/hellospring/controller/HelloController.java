package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        // 현재 Attribute에 key값을 data 그리고 그 value값을 hello!!라고 지정을하였다.
        // 여기의 data는 HelloController.java로 이동하여 hello!!라는 값을 ${data}에게 넘겨준다.
        model.addAttribute("data", "hello!!");
        return "hello";
        // 여기서 return값인 "hello"는 우리가 값을보낸 html파일인 hello와 이름이 똑같다.
    }

    // model에 담아야 view에서 attribute해서 보여주는것
    // hello-template html파일을 브라우저에서 열어주려면
    //localhost:8080/hello-mvc 라고 쳐야한다.
    // 지금 바로치면 에러가 나는데 이 경우에는 콘솔창을 확인해보자 맨 아래에 WARN이라고 있다
    // Required request parameter 'name' for method parameter type String is not present.
    // name이 정의가 안되어있다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
