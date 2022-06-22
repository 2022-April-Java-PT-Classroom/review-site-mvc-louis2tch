package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.wecancoeit.reviews.model.ReviewCategory;
import org.wecancoeit.reviews.repo.ReviewCategoryRepository;
import org.wecancoeit.reviews.repo.ReviewRepository;
import org.wecancoeit.reviews.repo.UserRepository;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private UserRepository userRepo;

    @Resource
    private ReviewCategoryRepository reviewCategoryRepo;

    @Resource
    private ReviewRepository reviewRepo;

    @GetMapping("/")
    public String getHomepage(Model modelUser, Model modelReviewCategory, Model modelReview){
        modelUser.addAttribute("users",userRepo.findAll());
        modelReviewCategory.addAttribute("categories", reviewCategoryRepo.findAll());
        modelReview.addAttribute("reviews", reviewRepo.findAll());

        return "home";
    }



}
