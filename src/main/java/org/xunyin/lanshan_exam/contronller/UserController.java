package org.xunyin.lanshan_exam.contronller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xunyin.lanshan_exam.Utils.JwtUtil;
import org.xunyin.lanshan_exam.pojo.Response;
import org.xunyin.lanshan_exam.pojo.User;
import org.xunyin.lanshan_exam.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@RequestParam String name, @RequestParam String password){

            User user = userService.findByName(name);
            if (user == null) {
                userService.register(name, password);
                return Response.success();
            } else {
                return Response.error("用户名已被占用");
            }
        }


    @PostMapping("/login")
    public Response login(String name, String password){
        User user = userService.findByName(name);
        if(user == null){
            return Response.error("用户名错误或不存在");
        }
         if(password.equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("name",user.getName());
            String token = JwtUtil.genToken(claims);
             return Response.success(token);
        }
           return Response.error("密码错误");
    }

    @GetMapping("/details")
    public Response<User> userDetails(@RequestHeader(name = "Authorization") String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        String name = (String) map.get("name");
        User user = userService.findByName(name);
        return Response.success(user);
    }

    @PutMapping("/update")
    public Response update(@RequestBody User user){
        userService.update(user);
        return Response.success();
    }

    @PatchMapping("/updateImage")
    public Response updateImage(@RequestParam @URL String ImageUrl){
        userService.updateImage(ImageUrl);
        return Response.success();
    }

    @PatchMapping("/updateWord")
    public Response updateWord(@RequestBody Map<String, String> params){
        String oldWord = params.get("old_word");
        String newWord = params.get("new_word");
        Integer id = Integer.valueOf(params.get("id"));
        if(oldWord == null || newWord == null){
            return Response.error("缺少数据");
        }
        userService.updateWord(newWord,id);
        return Response.success();
    }
}
