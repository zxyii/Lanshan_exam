package org.xunyin.lanshan_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xunyin.lanshan_exam.Utils.ThreadLocalUtil;
import org.xunyin.lanshan_exam.mapper.CommentMapper;
import org.xunyin.lanshan_exam.pojo.Comment;
import org.xunyin.lanshan_exam.service.CommentService;

import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = ThreadLocalUtil.get();
        String name =(String) map.get("name");
        Integer userId = (Integer) map.get("id");
        comment.setUserName(name);
        comment.setUserId(userId);
        commentMapper.add(comment);
    }
}
