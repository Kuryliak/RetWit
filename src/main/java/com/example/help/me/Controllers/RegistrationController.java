package com.example.help.me.Controllers;

import com.example.help.me.Models.Role;
import com.example.help.me.Models.User;
import com.example.help.me.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String newUser(User user, Map<String,Object> model){
//fix this shit tomorrow
         =  userRepository.findByUsername(userDb.getUsername());
        if(userDb != null){
        model.put("message","users exist");
        return "registration";
        }
        userDb.setActive(true);
        userDb.setRoles(Collections.singleton(Role.user));
        return "redirect:/main";
    }
}
