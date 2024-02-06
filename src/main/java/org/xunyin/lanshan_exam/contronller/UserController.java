package org.xunyin.lanshan_exam.contronller;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xunyin.lanshan_exam.Utils.ThteadLocalUtil;
import org.xunyin.lanshan_exam.pojo.Response;
import org.xunyin.lanshan_exam.pojo.User;
import org.xunyin.lanshan_exam.service.UserService;

import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@Pattern(regexp = "^\\s{5,16}$") String name,@Pattern(regexp = "^\\s{5,16}$")String password){
        if(name !=null && password != null && password.length() >= 6) {
            User user = userService.findByName(name);
            if (user == null) {
                userService.register(name, password);
                return Response.success();
            } else {
                return Response.error("用户名已被占用");
            }
        }
        else{
            return Response.error("密码不规范");
        }
    }

    @PostMapping("/login")
    public Response login(String name, String password){
        User user = userService.findByName(name);
        if(user == null){
            return Response.error("用户名错误或不存在");
        }
        else if(password.equals(user.getPassword())){
            return Response.success(user.getId() + user.getName());
        }else{
           return Response.error("密码错误");
        }
    }

    @GetMapping("/details")
    public Response userDetails(){
        Map<String, Object> map = ThteadLocalUtil.get();
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
    public Response updateWord(String newPassword){
        userService.updateWord(newPassword);
        return Response.success();
    }


}
