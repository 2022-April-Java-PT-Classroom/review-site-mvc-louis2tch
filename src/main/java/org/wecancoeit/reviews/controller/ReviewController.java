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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("reviews")
public class ReviewController {
    @Resource
    private ReviewRepository reviewRepo;

    @Resource
    private ReviewCategoryRepository categoryRepo;

    @Resource
    private UserRepository userRepo;

    @GetMapping("")
    public String allCategories(Model modelReview, Model modelCategory, Model modelUser){
        modelReview.addAttribute("reviews", reviewRepo.findAll());
        modelCategory.addAttribute("categories", categoryRepo.findAll());
        modelUser.addAttribute("users", userRepo.findAll());
        return "reviews";
    }

    @GetMapping("/{id}")
    public String oneReview(Model modelReview, Model modelCategory, Model modelUser, @PathVariable Long id){
        modelReview.addAttribute("review", reviewRepo.findById(id).get());
        modelCategory.addAttribute("categories", categoryRepo.findAll());
       // System.out.println();
        return "single-review";
    }

    @PostMapping("/addReview")
    public String addUser(/*@RequestParam Date date,*/
                          @RequestParam String title,
                          @RequestParam String description,
                          @RequestParam String content,
                          @RequestParam String userId,
                          @RequestParam String categoryId){

        Date d = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //"MM/dd/yyyy hh:mm:ss"
        String dateStr = df.format(d);

        Long userIdL = Long.parseLong(userId);
        User user = userRepo.findById(userIdL).get();
//        ArrayList<User> user = new ArrayList<>();
//        user.add(userRepo.findById(userIdL).get());

        Long categoryIdL = Long.parseLong(categoryId);
        ReviewCategory category = categoryRepo.findById(categoryIdL).get();

        Review reviewToAdd = new Review(dateStr, title, description, content, user, category);
        reviewRepo.save(reviewToAdd);
        return "redirect:/reviews";
    }
}
