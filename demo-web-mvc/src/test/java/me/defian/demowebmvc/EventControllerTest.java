package me.defian.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class EventControllerTest {


    @Autowired
    MockMvc mockMvc;

//    @Test
//    public void hello() throws Exception {
////        mockMvc.perform(get("/hi/defian"))
////                .andDo(print())
////                .andExpect(status().isOk())
//////                .andExpect(status().isMethodNotAllowed())
////                .andExpect(content().string("hello defian"))
////        ;
//
//        mockMvc.perform(get("/hello")
////                        .contentType(MediaType.APPLICATION_JSON_UTF8)
////                        .accept(MediaType.APPLICATION_JSON)
//                        .header(HttpHeaders.FROM,"localhost")
//                        .param("name","defian")
//                        )
//                .andDo(print())
//                .andExpect(status().isOk())
////                .andExpect(header().exists(HttpHeaders.ALLOW))
////                .andExpect(header().stringValues(HttpHeaders.ALLOW,
////                        hasItems(
////                                containsString("GET"),
////                                containsString("POST"),
////                                containsString("HEAD"),
////                                containsString("OPTIONS")
////                        )))
////                .andExpect(status().isMethodNotAllowed())
//                .andExpect(content().string("hello"))
////                .andExpect(handler().handlerType(SampleController.class))
////                .andExpect(handler().methodName("hello"))
//        ;
//
//    }


    @Test
    public void deleteEvent() throws Exception {
//        mockMvc.perform(post("/events?name=defian"))
        mockMvc.perform(post("/events")
                .param("name","defian")
                .param("limit","-10")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("defian"));
    }

    @Test
    public void eventForm() throws Exception{
        MockHttpServletRequest result = mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                .andReturn().getRequest();//                .andExpect(request().sessionAttribute("event",notNullValue()))
        Object event = result.getSession().getAttribute("event");
        System.out.println("event = " + event);

    }

    @Test
    public void postEvent() throws Exception {
        ResultActions result = mockMvc.perform(post("/events")
                .param("name","defian")
                .param("limit","-10")
                )
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(model().hasErrors())
                ;
        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String,Object> model = mav.getModel();
        System.out.println(model.size());
    }

    @Test
    public void getEvents() throws Exception {
        Event event = new Event();
        event.setName("defian");
        event.setLimit(4);

        mockMvc.perform(get("/events/list")
                    .sessionAttr("visitTime", LocalDateTime.now())
                   .flashAttr("newEvent",event)
                    )
                .andDo(print())
                .andExpect(model().attributeExists("categories"))
                .andExpect(xpath("//p").nodeCount(1));
    }
}