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

    //@OneToMany(targetEntity = Post.class,cascade = CascadeType.ALL)
     @OneToMany
    private List<Post> posts;

    @ElementCollection
    private List<String> follower=new ArrayList<>();
}
