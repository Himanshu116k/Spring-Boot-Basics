package com.himanshu.store.controllers;

import com.himanshu.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/check")
    public Message sayHello(){
        return new Message( "Hello World");
    }

}
