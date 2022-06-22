package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class ReviewCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @Lob
    private String categoryContent;
    private String categoryImg;
    private String categoryLink;
//    @OneToMany//(mappedBy = "reviewCategory")
//    private Collection<Review> reviews;

    public ReviewCategory(String categoryName, String categoryContent, String categoryImg, String categoryLink) {
        this.categoryName = categoryName;
        this.categoryContent = categoryContent;
        this.categoryImg = categoryImg;
        this.categoryLink = categoryLink;
    }

    public ReviewCategory(){

    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryContent() {
        return categoryContent;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public String getCategoryLink() {
        return categoryLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryContent(String categoryContent) {
        this.categoryContent = categoryContent;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public void setCategoryLink(String categoryLink) {
        this.categoryLink = categoryLink;
    }



    @Override
    public String toString() {
        return "ReviewCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryContent='" + categoryContent + '\'' +
                ", categoryImg='" + categoryImg + '\'' +
                ", categoryLink='" + categoryLink + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewCategory reviewCategory = (ReviewCategory) o;
        return Objects.equals(id, reviewCategory.id) && Objects.equals(categoryName, reviewCategory.categoryName)
                && Objects.equals(categoryContent, reviewCategory.categoryContent)
                && Objects.equals(categoryImg, reviewCategory.categoryImg)
                && Objects.equals(categoryLink, reviewCategory.categoryLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryContent, categoryImg, categoryLink);
    }

//    public void setId(){
//        this.id = 100L;
//    }

}
