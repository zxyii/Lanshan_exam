package org.xunyin.lanshan_exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Integer id;
    private String movieName;
    private String content;
    private String userName;
    private Integer userId;
    private double score;
    private Integer up;
}
