package org.xunyin.lanshan_exam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xunyin.lanshan_exam.pojo.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Select("SELECT * FROM movie")
    public List<Movie> movieList();

    @Select("SELECT * FROM movie WHERE name LIKE #{name}")
    public List<Movie> searchByName(String name);

    @Select("SELECT * FROM movie WHERE actor = #{actor}")
    public List<Movie> searchByActor(String actor);

    @Select("SELECT * FROM movie ORDER BY score DESC ")
    public  List<Movie>  searchByScore();
}
