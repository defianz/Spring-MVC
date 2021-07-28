package me.defian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public  String hello(@PathVariable int id, @RequestParam String name){
        return "Hello, " + helloService.getName();
    }

    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }

}
