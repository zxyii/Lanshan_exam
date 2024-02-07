package org.xunyin.lanshan_exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.spi.DirStateFactory;
import javax.xml.transform.Result;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String message;
    private T data; //响应数据

    public static Response success(){
        return new Response(0,"success",null);
    }
    public static <E> Response<E> success(E data){
        return new Response<>(0,"success",data);
    }
    public static Response error(String message){
        return new Response(1,message,null);
    }

}
