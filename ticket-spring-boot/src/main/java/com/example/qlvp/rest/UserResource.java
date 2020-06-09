package com.example.qlvp.rest;

import com.example.qlvp.modal.User;
import com.example.qlvp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SessionAttributes({"email"})
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/checkLogin")
    public boolean check(@PathVariable String email,@PathVariable String passWord, ModelMap modelMap){
        boolean kiemtra = userService.loginUser(email,passWord);
        if(kiemtra){
            modelMap.addAttribute("email",email);
        }
        return kiemtra;
    }

    @GetMapping("/checkRegistry")
    public boolean check(@PathVariable String email){
        return userService.checkRegistry(email);
    }


    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }



}
