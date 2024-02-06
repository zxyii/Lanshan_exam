package org.xunyin.lanshan_exam.service;

import org.xunyin.lanshan_exam.pojo.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> movieList();
    public List<Movie> searchByName(String name);
    public List<Movie> searchByActor(String actor);
    public List<Movie> searchByScore();
}
