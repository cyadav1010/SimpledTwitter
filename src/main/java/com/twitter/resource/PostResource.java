package com.twitter.resource;


import com.twitter.entity.Post;
import com.twitter.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostResource {

    @Autowired
    private PostService postService;

    @PostMapping("/create/{username}")
    public void createPost(@RequestBody Post post,@PathVariable String username){
        log.info("post = " + post);
        postService.save(post,username);
    }

    @PostMapping("/like/{username}/{postid}")
    public  void likePost(@PathVariable Integer postid, @PathVariable String username){
        log.info("postid = " + postid + ", username = " + username);
        postService.likePost(username,postid);
    }

    @GetMapping("/{username}")
    public List<Post> allPostUser(@PathVariable String username){
     return postService.getAllPost(username);
    }
}
