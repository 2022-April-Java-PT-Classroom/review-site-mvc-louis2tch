package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userNick;
    private String userAvatarUrl;
//    @OneToMany //(mappedBy = "user")
//    private Collection<Review> reviews;

    public User(String userNick, String userAvatarUrl) {
        this.userNick = userNick;
        this.userAvatarUrl = userAvatarUrl;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNick='" + userNick + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && userNick.equals(user.userNick) && userAvatarUrl.equals(user.userAvatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNick, userAvatarUrl);
    }
}
