package me.defian.demospringmvc;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    public List<Event> getEvents(){
        Event event1 = Event.builder().
                name("스프링 웹 MVC 스터디")
                .limintOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019,1,10,10,0))
                .endDateTime(LocalDateTime.of(2021,7,27,10,0))
                .build();
        Event event2 = Event.builder().
                name("스프링 웹 MVC 스터디 2차")
                .limintOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019,1,15,10,0))
                .endDateTime(LocalDateTime.of(2021,7,30,10,0))
                .build();

        return List.of(event1,event2);
    }
}
