package me.defian.demowebmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class})
public class BaseController {
}
