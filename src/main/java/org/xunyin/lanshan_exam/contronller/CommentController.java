package org.xunyin.lanshan_exam.contronller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xunyin.lanshan_exam.pojo.Comment;
import org.xunyin.lanshan_exam.pojo.Response;
import org.xunyin.lanshan_exam.service.CommentService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/commentOfMovie")
    public Response commentList(String name){
        log.info("电影评论");
        List<Comment> commentList = commentService.commentList(name);
        return Response.success();
    }

    @GetMapping("/scoreOfMovie")
    public Response score(String name){
        log.info("电影评分");
        double score = commentService.selectScore(name);
        return Response.success();
    }

    @PostMapping("/add")
    public Response add(@RequestBody Comment comment){
        commentService.add(comment);
        return Response.success();
    }
}
