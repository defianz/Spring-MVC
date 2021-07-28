package me.defian.demobootweb;


import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello "+ person.getName();
    }

    @GetMapping("/message")
    public @ResponseBody String message(@RequestBody String body){
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person){
        return person;
    }
}
