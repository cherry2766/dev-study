package com.msa.comments.controller;

import com.msa.comments.recode.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class CommentController {

    private static final Log logger = LogFactory.getLog(CommentController.class);

    @Autowired
    private RestClient restClient;

    @GetMapping("/comments")
    public Comment[] comments(@RequestParam(defaultValue = "1") String postId) {
        logger.info("/comments has been called");
        throw new NullPointerException("null point error");
        //https://jsonplaceholder.typicode.com/comments?postId=1
        /*Comment[] comments = restClient
                .get().uri("https://jsonplaceholder.typicode.com/comments?postId={postId}", postId)
                .retrieve()
                .body(Comment[].class);
        return comments;*/
    }
}
