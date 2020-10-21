package com.twitter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

//    @OneToMany
    @OneToMany(targetEntity = Post.class,cascade = CascadeType.ALL)
    private List<Post> posts;

    @ElementCollection
    private List<String> follower=new ArrayList<>();

//    @ElementCollection
//    private List<Integer> postLikes=new ArrayList<>();

//    @ManyToMany
//    List<User> userList = new ArrayList<>();
}
