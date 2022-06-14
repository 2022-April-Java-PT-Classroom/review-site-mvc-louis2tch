package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancoeit.reviews.model.User;
import org.wecancoeit.reviews.repo.ReviewRepository;
import org.wecancoeit.reviews.repo.UserRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserRepository userRepo;

    @Resource
    private ReviewRepository reviewRepo;

    @GetMapping("")
    public String allUsers(Model modelUser){
        modelUser.addAttribute("users", userRepo.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String oneUser(Model modelUser, @PathVariable Long id){
        modelUser.addAttribute("user", userRepo.findById(id).get());
        return "single-user";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String userNick,
                             @RequestParam String userAvatarUrl){
        User userToAdd = new User(userNick,userAvatarUrl);
        userRepo.save(userToAdd);
        return "redirect:/users";
    }
}
