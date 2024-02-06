package org.xunyin.lanshan_exam.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xunyin.lanshan_exam.pojo.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(String name);

    @Insert("INSERT INTO user(name,password)" +
            "valuse(#{name},#{password})")
    void add(String name, String password);

    @Update("UPDATE user SET name = #{name} where id = #{id}")
    void update(User user);

    @Update(("UPDATE user SET image = #{ImageUrl} WHERE id = #{id}"))
    void updateImage(String ImageUrl, Integer id);

   @Update("UPDATE user SET password = #{newPassword} WHERE id = #{id}")
    void updateWord(String newPassword, Integer id);
}
