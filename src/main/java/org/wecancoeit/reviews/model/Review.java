package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
