package com.example.help.me.Controllers;

import com.example.help.me.Models.Message;
import com.example.help.me.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public String main(Model model,String filter) {
        Iterable<Message> messages = messageRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter",filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,@RequestParam("file") MultipartFile file,
                      @RequestParam String message, @RequestParam String tag, Map<String, Object> model) throws IOException {
        Message message1 = new Message(message,tag);

        if (file!= null && !file.getOriginalFilename().isEmpty()){
          File uploadDirectory = new File(uploadPath);
          if (!uploadDirectory.exists()){
              uploadDirectory.mkdir();
          }
           String randomid =  UUID.randomUUID().toString();
            String resultname =  randomid + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath +"/" + resultname));

            message1.setFile(resultname);
        }

        messageRepository.save(message1);

        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }

}


