package com.twitter.service;

import com.twitter.dao.PostDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.Post;
import com.twitter.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        List<Post> posts = user.getPosts();
        posts.forEach(post -> {
            // postDao.save(post);
        });
        userDao.save(user);
        System.out.println("user Details save");
    }

    public User searchUserHandle(String username) {
        return userDao.findByUserName(username);
    }

    public Optional<User> findUserById(Integer userId) {
        return userDao.findById(userId);
    }

    public Post getUserPostId(Integer userId, Integer id) {
        log.info("userId = " + userId + ", id = " + id);
        Optional<User> userById = findUserById(userId);
        if (userById.isPresent()) {
            List<Post> posts = userById.get().getPosts();
            Optional<Post> anyPost = posts.stream().filter(post -> post.getId() == id).findAny();
            if (anyPost.isPresent()) {
                return anyPost.get();
            }
        }
        return null;
    }

    public List<Post> searchByUserIdFeed(Integer userId) {
        Optional<User> userById = findUserById(userId);
        List<Post> result = new ArrayList<>();
        if (userById.isPresent()) {
            System.out.println("userById = " + userById);
            User user = userById.get();
            List<String> follower = user.getFollower();
            follower.forEach(f -> {
                System.out.println("f = " + f);
                User byUserName = userDao.findByUserName(f);
                System.out.println("byUserName = " + byUserName);
                if (byUserName != null) {
                    result.addAll(byUserName.getPosts());
                }
            });
            return result;
        }
        return null;
    }

    public List<String> searchByUserIdFollowPost(Integer userId, List<String> followers) {
        Optional<User> userById = findUserById(userId);
        if (userById.isPresent()) {
            User user = userById.get();
            List<String> follower = user.getFollower();
            followers.forEach(f -> {
                follower.add(f);
            });
            userDao.save(user);
            return follower;
        }
        return null;
    }

    public List<String> searchByUserIdFollow(Integer userId) {
        Optional<User> userById = findUserById(userId);
        if (userById.isPresent()) {
            User user = userById.get();
            List<String> follower = user.getFollower();
            return follower;
        }
        return null;
    }

    public Post getUserPostLike(Integer userId, Integer id) {
        Optional<User> userById = findUserById(userId);
        if (userById.isPresent()) {
            List<Post> posts = userById.get().getPosts();
            Optional<Post> anyPost = posts.stream().filter(post -> post.getId() == id).findAny();
            if (anyPost.isPresent()) {
                Post post = anyPost.get();
                Integer likeCount = post.getLikeCount();
                likeCount++;
                post.setLikeCount(likeCount);
                postDao.save(post);
                return post;
            }
        }
        return null;
    }

    public List<Post> getUserPost(Integer userId) {

        Optional<User> userById = findUserById(userId);
        if (userById.isPresent()) {
            return userById.get().getPosts();
        }
        return null;
    }

    public List<Post> addUserPost(Integer userId, Post post) {
        Optional<User> userById = findUserById(userId);
        String message = post.getMessage();
        int len=message.length();
        System.out.println("count = " + len);
        if (len>=140) {
            return null;
        }
        if (userById.isPresent()) {
            User user = userById.get();
            List<Post> postList = user.getPosts();
            postList.add(post);
            postDao.save(post);
            userDao.save(user);
            return postList;
        }
        return null;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
