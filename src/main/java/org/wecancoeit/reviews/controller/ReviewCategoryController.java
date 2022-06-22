package org.wecancoeit.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancoeit.reviews.model.ReviewCategory;
import org.wecancoeit.reviews.model.User;
import org.wecancoeit.reviews.repo.ReviewCategoryRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/categories")
public class ReviewCategoryController {
    @Resource
    private ReviewCategoryRepository reviewCategoryRepo;

    @GetMapping("")
    public String allCategories(Model modelCategory){
        modelCategory.addAttribute("categories", reviewCategoryRepo.findAll());
        return "categories";
    }

    @GetMapping("/{id}")
    public String oneCategory(Model modelCategory, @PathVariable Long id){
        modelCategory.addAttribute("category", reviewCategoryRepo.findById(id).get());
        return "single-category";
    }

    @PostMapping("/addCategory")
    public String addUser(@RequestParam String categoryName,
                          @RequestParam String categoryContent,
                          @RequestParam String categoryImg,
                          @RequestParam String categoryLink){
        ReviewCategory categoryToAdd = new ReviewCategory(categoryName, categoryContent,
                categoryImg, categoryLink);
        reviewCategoryRepo.save(categoryToAdd);
        return "redirect:/categories";
    }

}
