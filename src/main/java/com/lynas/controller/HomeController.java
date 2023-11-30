package com.lynas.controller;

import com.lynas.model.User;
import com.lynas.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by sazzad on 2/11/16
 */
@Controller
public class HomeController {

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreeterService greeting(User message) throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("HH:mm");
        Thread.sleep(3000); // simulated delay
        return new GreeterService( message.getName() + ": "+message.getMess()+"              "+dtf.format(localDateTime));
    }

    @RequestMapping(value = "/simMessage")
    public String greeting() throws Exception {
        template.convertAndSend("/topic/greetings",
                new GreeterService("Hello, Other!"));
        return "sample";
    }
}
