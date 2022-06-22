package org.wecancoeit.reviews.model;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.*;

import org.wecancoeit.reviews.repo.ReviewCategoryRepository;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String title;
    @Lob
    private String description;
    @Lob
    private String content;
    @ManyToOne
    private User users;

    @ManyToOne
    private ReviewCategory reviewCategories;

    public Review(String date, String title, String description, String content,  User users, ReviewCategory reviewCategories) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.content = content;
        this.users = users; //List.of(users);
        this.reviewCategories = reviewCategories;//List.of(reviewCategories);
    }

    public Review() {
    }

    HashMap<Long, ReviewCategory> category = new HashMap<>();
    public ReviewCategory getOneCategory(Long Id) {
        return category.get(Id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public ReviewCategory getReviewCategories() {
        return reviewCategories;
    }



//    public Optional<ReviewCategory> getOneCategory(Long Id) {
//        ReviewCategoryRepository categoryRepo = null;
//        return categoryRepo.findById(Id);
//
//    }


//    public void addOneCategory(ReviewCategory catToAdd) {
//        category.put(catToAdd.getId(), catToAdd);
//    }
//    public Collection<ReviewCategory> getAllCategories(){
//        return category.values();
//    }

    public void setReviewCategories(ReviewCategory reviewCategories) {
        this.reviewCategories = reviewCategories;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id) && date.equals(review.date) && title.equals(review.title)
                && description.equals(review.description) && content.equals(review.content);
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(id, date, title, description, content);
    }


}
