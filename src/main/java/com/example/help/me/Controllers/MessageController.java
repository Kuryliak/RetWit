package com.example.help.me.Controllers;

import com.example.help.me.Models.Message;
import com.example.help.me.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;



    @GetMapping("/")
    public String helloPage(){
        return "firstpage";
    }
    @GetMapping("/main")
    public String main(Map<String,Object> model){
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages",messages);
        return "main";
    }
    @PostMapping("/main")
    public String add(@RequestParam String message, @RequestParam String tag, Map<String,Object> model){
         Message message1 = new Message(message,tag);
          messageRepository.save(message1);
        Iterable<Message> messages = messageRepository.findAll();
         model.put("messages",messages);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
       if (filter != null && !filter.isEmpty()){
           messages = messageRepository.findByTag(filter);
       }else {
           messages = messageRepository.findAll();
       }

       model.put("messages",messages);


        return "main";
    }
}


