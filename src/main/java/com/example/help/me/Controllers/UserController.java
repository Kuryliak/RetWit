package com.example.help.me.Controllers;

import com.example.help.me.Models.Role;
import com.example.help.me.Models.User;
import com.example.help.me.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }


     @GetMapping("{user}")
    public String userEditForm(Model model,@PathVariable User user) {
        model.addAttribute("user",user);
        model.addAttribute("roles",Role.values());
        return "userEdit";


}
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveUser(user,username,form);

        return "redirect:/user";
    }
    @GetMapping("profile")
    public String userProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("userId",user.getId());
        return "profile";
    }
    @PostMapping("profile")
    public String saveUserProfileChanges(@AuthenticationPrincipal User user,

            @RequestParam String password,Model model){
        userService.updateUser(user,password);
        return "redirect:/user/profile";
    }
    @GetMapping("subscribe/{user}")
    public String subscribe(@AuthenticationPrincipal User currentUser,
                            @PathVariable User user){
       userService.subscribe(currentUser, user);

       return "redirect:/user-messages/" + user.getId();
    }
    @GetMapping("unsubscribe/{user}")
    public String unsubscribe(@AuthenticationPrincipal User currentUser,
                            @PathVariable User user){
       userService.unsubscribe(currentUser, user);

       return "redirect:/user-messages/" + user.getId();
    }
    @GetMapping("{type}/{user}/list")
    public String listUsers(@PathVariable User user,@PathVariable String type,Model model){
        model.addAttribute("userChannel",user);
        model.addAttribute("type",type);
        if ("subscriptions".equals(type)){
            model.addAttribute("users",user.getSubriptions());
        }else{
            model.addAttribute("users",user.getSubrscribers());
        }
        return "subscriptions";

    }
}