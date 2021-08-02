package me.defian.demowebmvc;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @ExceptionHandler
    public ResponseEntity errorHandler(){
        return ResponseEntity.badRequest().body("error")
    }

    @PostMapping
    public Event createEvent(@RequestBody @Validated Event event, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error);
            });
        }
        // save
        return event;
    }
}
