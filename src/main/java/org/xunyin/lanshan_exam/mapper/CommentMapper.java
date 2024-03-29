package org.xunyin.lanshan_exam.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xunyin.lanshan_exam.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
   @Select("SELECT content FROM comment WHERE movie_name = #{name}")
    public List<Comment> commentList(String name);
    @Select("SELECT AVG(score) FROM comment WHERE movie_name = #{name}")
    public double selectScore(String name);

   @Insert("INSERT INTO comment(movie_name,user_id,user_name,content,score)" +
           "VALUES (#{movieName},#{userId},#{userName},#{content},#{score})")
    void add(Comment comment);
}
