package org.xunyin.lanshan_exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;
    private String name;
    private double score;
    private String introduction; //简介
    private String actor;
    private String movieImage;

}
