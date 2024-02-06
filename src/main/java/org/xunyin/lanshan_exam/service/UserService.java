package org.xunyin.lanshan_exam.service;

import org.xunyin.lanshan_exam.pojo.User;

public interface UserService {
    User findByName(String name);

    void register(String name, String password);


    void update(User user);

    void updateImage(String ImageUrl);

    void updateWord(String newPassword);
}
