package org.xunyin.lanshan_exam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.spi.DirStateFactory;
import javax.xml.transform.Result;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer code; //1:成功 0：失败
    private String message;
    private Object data;

    public static Response success(){
        return new Response(1,"success",null);
    }
    public static Response success(Object data){
        return new Response(1,"success",data);
    }
    public static Response error(String message){
        return new Response(0,message,null);
    }

}
