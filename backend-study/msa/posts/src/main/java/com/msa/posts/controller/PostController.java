package com.msa.posts.controller;

import com.msa.posts.record.Comment;
import com.msa.posts.record.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    private static final Log logger = LogFactory.getLog(PostController.class);

    @Autowired
    private RestClient restClient;

    @GetMapping("/posts") //http://localhost8081/posts
    public Post[] posts() {
        System.out.println(restClient);
        //https://jsonplaceholder.typicode.com/posts
        Post[] posts = restClient
                .get().uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .body(Post[].class);
        return posts;
    }

    @GetMapping("/posts/{id}") //http://localhost8081/posts/1
    public Map post(@PathVariable int id) {
        //System.out.println(restClient);
        System.out.println(id);
        logger.info("/posts/{id} has been called");
        //https://jsonplaceholder.typicode.com/posts
        Post post = restClient
                .get().uri("http://jsonplaceholder.typicode.com/posts/{id}", id)
                .retrieve()
                .body(Post.class);
        Map<String, Object> map = new HashMap();
        map.put("post", post);
        try {
            Comment[] comments = restClient
                    .get().uri("http://localhost:8082/comments?postId={id}", id)
                    .retrieve()
                    .body(Comment[].class);
            map.put("comments", comments);
        } catch (Exception e) {
            map.put("comments", null);
        }
        return map;
    }
}
