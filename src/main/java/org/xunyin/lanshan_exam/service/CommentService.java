package org.xunyin.lanshan_exam.service;

import org.springframework.stereotype.Service;
import org.xunyin.lanshan_exam.pojo.Comment;

import java.util.List;


public interface CommentService {
    public List<Comment> commentList(String name);
    public double selectScore(String name);

    void add(Comment comment);
}
