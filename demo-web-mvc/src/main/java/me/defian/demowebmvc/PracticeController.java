package me.defian.demowebmvc;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@ResponseBody
//@RequestMapping(value = "/events")
public class PracticeController {



    @GetMapping("**")
    public String number1(){
        return "number1";
    }

    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String number3(){
        return "number2";
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/?")
    public String number4(){
        return "nubmer3";
    }

    @RequestMapping(value="/?", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String number5(){
        return "number4";
    }

}
