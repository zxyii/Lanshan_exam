package org.xunyin.lanshan_exam.contronller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xunyin.lanshan_exam.Utils.JwtUtil;
import org.xunyin.lanshan_exam.pojo.Movie;
import org.xunyin.lanshan_exam.pojo.Response;
import org.xunyin.lanshan_exam.service.MovieService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @RequestMapping("/list")
    public Response list(){

        log.info("查询所有电影");
        List<Movie> movieList = movieService.movieList();
        return Response.success("所有电影数据如下：");
    }

    @GetMapping("/nameOfMovie")
    public Response searchByname(String name){
        log.info("根据关键字查询电影");
        List<Movie> moveOfName = movieService.searchByName(name);
        return Response.success();
    }

    @GetMapping("actorOfMovie")
    public Response searchByActor(String actor){
        log.info("根据演员查询电影");
        List<Movie> movieOfActor = movieService.searchByActor(actor);
        return Response.success();
    }
    @GetMapping("/rank")
    public Response searchByScore(){
        log.info("按评分降序查询");
        List<Movie> movieOfScore = movieService.searchByScore();
        return Response.success();
    }

}
