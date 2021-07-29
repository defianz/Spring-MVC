package me.defian.demowebmvc;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(value="/hello",method = RequestMethod.GET)
public class SampleController {

//    @GetMapping( {"/{name:[a-z]+}"})
//    @RequestMapping(
//            value = "/hello",
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.TEXT_PLAIN_VALUE
//    )
//    @RequestMapping(value = "/hello", headers = HttpHeaders.FROM + "=" + "localhost", params = "name=defian")
//    @GetHelloMapping
//    @ResponseBody
////    public String hello(@PathVariable String name){
//    public String hello(){
//        return "hello";
//    }

//        @GetMapping("/events/{id}")
//        @ResponseBody
//        public Event getEvent(@PathVariable("id") Integer idValue, @MatrixVariable String name){
//                Event event = new Event();
//                event.setId(idValue);
//                event.setName(name);
//                return event;
//        }

        @PostMapping("/events")
//        @ResponseBody
//        public Event getEvent(@RequestParam(value = "name", required = true, defaultValue = "defian") String name){
//        public Event getEvent(@Validated({Event.ValidateLimit.class}) @ModelAttribute Event event, BindingResult bindingResult){
        public String getEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult, Model model){
                if(bindingResult.hasErrors()){
                        System.out.println("=====================");
                        bindingResult.getAllErrors().forEach(c -> {
                                System.out.println(c.toString());
                        });
                        return "/events/form";
                }
                List<Event> eventList = new ArrayList<>();
                eventList.add(event);
                model.addAttribute("eventList",eventList);

                return "redirect:/events/list";
        }

        @GetMapping("/events/list")
        public String getEvents(Model model){
                Event event = new Event();
                event.setName("defian-refresh");
                event.setLimit(100);
                List<Event> eventList = new ArrayList<>();
                eventList.add(event);
                model.addAttribute("eventList",eventList);

                return "/events/list";
        }

        @GetMapping("/events/form")
        public String eventsForm(Model model){
                Event event = new Event();
                event.setName("defian");
                event.setLimit(10);

                model.addAttribute("event",event);
                return "events/form";
        }



}
