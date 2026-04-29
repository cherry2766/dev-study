package com.msa.comments.controller;

import com.msa.comments.recode.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class CommentController {

    @Autowired
    private RestClient restClient;

    @GetMapping("/comments")
    public Comment[] comments(@RequestParam(defaultValue = "1") String postId) {
        //https://jsonplaceholder.typicode.com/comments?postId=1
        Comment[] comments = restClient
                .get().uri("https://jsonplaceholder.typicode.com/comments?postId={postId}", postId)
                .retrieve()
                .body(Comment[].class);
        return comments;
    }
}
