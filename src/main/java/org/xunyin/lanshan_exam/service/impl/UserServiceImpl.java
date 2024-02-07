package org.xunyin.lanshan_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.xunyin.lanshan_exam.Utils.Md5Util;*/
import org.xunyin.lanshan_exam.Utils.ThreadLocalUtil;
import org.xunyin.lanshan_exam.mapper.UserMapper;
import org.xunyin.lanshan_exam.pojo.User;
import org.xunyin.lanshan_exam.service.UserService;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }
    @Override
    public void register(String name, String password) {

        userMapper.add(name,password);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateImage(String ImageUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateImage(ImageUrl,id);
    }

    @Override
    public void updateWord(String newPassword,Integer id) {
        /*Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");*/
        userMapper.updateWord(newPassword,id);
    }
}
