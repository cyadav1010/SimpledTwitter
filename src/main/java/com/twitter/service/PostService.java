package com.twitter.service;

import com.twitter.dao.PostDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.Post;
import com.twitter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public void save(Post post, String username) {
        User user = userDao.findByUserName(username);
        user.getPosts().add(post);
//        user.setPosts(user.getPosts());
        userDao.save(user);
        postDao.save(post);
    }

    public void likePost(String username, Integer postid) {
        // User user = userDao.findByUserName(username);
        Optional<Post> post = postDao.findById(postid);
        if (post.isPresent()) {
            Post post1 = post.get();
            Integer likeCount = post1.getLikeCount();
            likeCount++;
            post1.setLikeCount(likeCount);
            postDao.save(post1);
//            List<Post> postList = user.getPosts();
//            postList.forEach(post2 -> {
//                if (post2.getId() == postid) {
//                    Integer likeCount1 = post2.getLikeCount();
//                    likeCount1++;
//                    post2.setLikeCount(likeCount1);
//                }
//            });
        }
    }

    public List<Post> getAllPost(String username) {
        User user = userDao.findByUserName(username);
        return user.getPosts();
    }
}
