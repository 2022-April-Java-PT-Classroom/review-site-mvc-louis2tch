package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.model.ReviewCategory;
import org.wecancoeit.reviews.model.User;
import org.wecancoeit.reviews.repo.ReviewCategoryRepository;
import org.wecancoeit.reviews.repo.ReviewRepository;
import org.wecancoeit.reviews.repo.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("reviews")
public class ReviewController {
    @Resource
    private ReviewRepository reviewRepo;

    @Resource
    private ReviewCategoryRepository reviewCategoryRepo;

    @Resource
    private UserRepository userRepo;

    @GetMapping("")
    public String allCategories(Model modelReview, Model modelCategory, Model modelUser){
        modelReview.addAttribute("reviews", reviewRepo.findAll());
        modelCategory.addAttribute("categories", reviewCategoryRepo.findAll());
        modelUser.addAttribute("users", userRepo.findAll());
        return "reviews";
    }

    @GetMapping("/{id}")
    public String oneReview(Model modelReview, @PathVariable Long id){
        modelReview.addAttribute("review", reviewRepo.findById(id).get());
        return "single-review";
    }

    @PostMapping("/addReview")
    public String addUser(@RequestParam String date,
                          @RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String content,
                          @RequestParam String userId,
                          @RequestParam String categoryId){
        Long userIdL = Long.parseLong(userId);
        User user = userRepo.findById(userIdL).get();
//        ArrayList<User> user = new ArrayList<>();
//        user.add(userRepo.findById(userIdL).get());

        Long categoryIdL = Long.parseLong(categoryId);
        ReviewCategory category = reviewCategoryRepo.findById(categoryIdL).get();

        Review reviewToAdd = new Review(date, title, description, content, user, category);
        reviewRepo.save(reviewToAdd);
        return "redirect:/reviews";
    }
}
