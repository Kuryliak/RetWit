package com.example.help.me.Controllers;

import com.example.help.me.Models.Message;
import com.example.help.me.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/")
    public String helloPage() {
        return "firstpage";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String message,
                      @RequestParam String tag, Map<String, Object> model,
                      @RequestParam("file")MultipartFile file) throws IOException {

        Message message1 = new Message(message, tag);

        if (file != null){
           File fileDir = new File(uploadPath);
           if (!fileDir.exists()){
               fileDir.mkdir();
           }
          String uuid =   UUID.randomUUID().toString();

          String resultFilename = uuid + "." + file.getOriginalFilename();
          file.transferTo(new File(uploadPath + "/"+ resultFilename));
            message1.setFilename(resultFilename);
        }
        messageRepository.save(message1);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
            } else {
                messages = messageRepository.findAll();
            }
            model.put("messages", messages);
                return "main";
        }
}


