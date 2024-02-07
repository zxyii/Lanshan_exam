package org.xunyin.lanshan_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xunyin.lanshan_exam.mapper.CommentMapper;
import org.xunyin.lanshan_exam.pojo.Comment;
import org.xunyin.lanshan_exam.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> commentList(String name) {
        return commentMapper.commentList(name);
    }

    @Override
    public double selectScore(String name) {
        return commentMapper.selectScore(name);
    }

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }
}
