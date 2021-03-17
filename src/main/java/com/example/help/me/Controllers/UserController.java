package com.example.help.me.Controllers;

import com.example.help.me.Models.Role;
import com.example.help.me.Models.User;
import com.example.help.me.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    private String userList(Model model){
        model.addAttribute("user",repository.findAll());
        return "users";
    }
    @GetMapping("{user}")
    public String editUser(@PathVariable User user,Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
     return "userEdit";
    }
    @PostMapping
    public String saveUser(@RequestParam String username,
                           @RequestParam Map<String,String> form,
                           @RequestParam("username")User user, Model model){
         user.setUsername(username);
     Set<String> roles =  Arrays.stream(Role.values())
             .map(Role::name)
             .collect(Collectors.toSet());

     user.getRoles().clear();

     for(String key : form.keySet()){
         if (roles.contains(key)){
          user.getRoles().add(Role.valueOf(key));
         }
        }
         repository.save(user);

              return "redirect:/user";
    }
}
