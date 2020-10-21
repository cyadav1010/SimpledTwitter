package com.twitter.resource;

import com.twitter.dao.PostDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.Post;
import com.twitter.entity.User;
import com.twitter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        log.info("UserController.getAllUser");
        return userService.findAll();

    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        log.info("user = " + user);
        userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public Optional<User> searchByUserId(@PathVariable Integer userId) {
        log.info("userId = " + userId);
        return userService.findUserById(userId);
    }

    @GetMapping("/{userId}/post")
    public List<Post> getUserPost(@PathVariable Integer userId) {
        log.info("userId = " + userId);
      return userService.getUserPost(userId);
    }

    @PostMapping("/{userId}/post")
    public List<Post> addUserPost(@PathVariable Integer userId, @RequestBody Post post) {
        log.info("userId = " + userId);
      return userService.addUserPost(userId,post);
    }

    @GetMapping("/{userId}/post/{id}")
    public Post getUserPostId(@PathVariable Integer userId, @PathVariable Integer id) {
        return userService.getUserPostId(userId, id);
    }

    @GetMapping("/{userId}/post/{id}/like")
    public Post getUserPostLike(@PathVariable Integer userId, @PathVariable Integer id) {
        System.out.println("userId " + userId);
     return userService.getUserPostLike(userId,id);
    }

    @GetMapping("/{userId}/follower")
    public List<String> searchByUserIdFollow(@PathVariable Integer userId) {
        System.out.println("userId " + userId);
       return userService.searchByUserIdFollow(userId);

    }

    @PostMapping("/{userId}/follower")
    public List<String> searchByUserIdFollowPost(@PathVariable Integer userId, @RequestBody List<String> followers) {
        System.out.println("userId " + userId);
        return userService.searchByUserIdFollowPost(userId, followers);
    }

    @GetMapping("/{userId}/feed")
    public List<Post> searchByUserIdFeed(@PathVariable Integer userId) {
        log.info("userId = " + userId);
        return userService.searchByUserIdFeed(userId);

    }
}
