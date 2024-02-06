package org.xunyin.lanshan_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xunyin.lanshan_exam.mapper.MovieMapper;
import org.xunyin.lanshan_exam.pojo.Movie;
import org.xunyin.lanshan_exam.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> movieList() {
        return movieMapper.movieList();
    }

    @Override
    public List<Movie> searchByName(String name) {
        return movieMapper.searchByName(name);
    }

    @Override
    public List<Movie> searchByActor(String actor) {
        return movieMapper.searchByActor(actor);
    }

    @Override
    public List<Movie> searchByScore() {
        return movieMapper.searchByScore();
    }
}
