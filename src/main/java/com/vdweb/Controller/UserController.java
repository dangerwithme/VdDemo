package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.UserMapper;
import com.vdweb.domain.Result;
import com.vdweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Integer id){
        return new Result(true,userMapper.selectById(id));
    }

    @GetMapping("/login")
    public Result login(@RequestParam("account") String username,@RequestParam("password") String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Object o = userMapper.selectOne(wrapper.eq("userEmail",username).eq("userpassword",password));
        if (o!=null) {
            return new Result(true, o);
        }else{
            return new Result(false,false);
        }
    }

}
