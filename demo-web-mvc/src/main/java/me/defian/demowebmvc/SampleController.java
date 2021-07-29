package me.defian.demowebmvc;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("event")
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

        @PostMapping("/events/form/name")
//        @ResponseBody
//        public Event getEvent(@RequestParam(value = "name", required = true, defaultValue = "defian") String name){
//        public Event getEvent(@Validated({Event.ValidateLimit.class}) @ModelAttribute Event event, BindingResult bindingResult){
        public String getEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult, Model model
        , SessionStatus sessionStatus){
                if(bindingResult.hasErrors()){
                        System.out.println("=====================");
                        bindingResult.getAllErrors().forEach(c -> {
                                System.out.println(c.toString());
                        });
                        return "/events/form-name";
                }
//                List<Event> eventList = new ArrayList<>();
//                eventList.add(event);
//                model.addAttribute("eventList",eventList);
//                sessionStatus.setComplete();
                return "redirect:/events/form/limit";
        }

        @PostMapping("/events/form/limit")
        public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event, BindingResult bindingResult
        , SessionStatus sessionStatus, Model model, RedirectAttributes redirectAttributes){
                if(bindingResult.hasErrors()){
                        return "/events/form-limit";
                }
//                redirectAttributes.addAttribute("name",event.getName());
//                redirectAttributes.addAttribute("limit",event.getLimit());
                redirectAttributes.addFlashAttribute("newEvent",event);
                return "redirect:/events/list";
        }

        @GetMapping("/events/list")
        public String getEvents(
//                @ModelAttribute("newEvent") Event newEvent,
                Model model, HttpSession httpSession, SessionStatus sessionStatus, @SessionAttribute("visitTime") LocalDateTime visitTime){
//                Event event = new Event();
//                event.setName("defian-refresh");
//                event.setLimit(100);
                System.out.println("visitTime = " + visitTime);
                List<Event> eventList = new ArrayList<>();
                eventList.add((Event) model.asMap().get("newEvent"));
                model.addAttribute("eventList",eventList);
                sessionStatus.setComplete();

                return "/events/list";
        }

        @GetMapping("/events/form/name")
        public String eventsForm(Model model, HttpSession httpSession){

                model.addAttribute("event",new Event());
//                httpSession.setAttribute("event",event);
                return "events/form-name";
        }

        @GetMapping("/events/form/limit")
        public String eventsFormLimit(@ModelAttribute Event event, Model model){

                model.addAttribute("event",event);
//                httpSession.setAttribute("event",event);
                return "events/form-limit";
        }

}
