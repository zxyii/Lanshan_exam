package org.xunyin.lanshan_exam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xunyin.lanshan_exam.pojo.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Select("SELECT * FROM movie")
    public List<Movie> movieList();


    public List<Movie> searchByName(String name);

    public List<Movie> searchByActor(String actor);

    public  List<Movie>  searchByScore();
}
