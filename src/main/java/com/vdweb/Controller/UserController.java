package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @GetMapping("/Emails")
    public Result getEmail(@RequestParam("email")String userEmail){
        return new Result(true,userMapper.selectOne(new QueryWrapper<User>().eq("userEmail",userEmail))!=null);
    }

    @PostMapping("/Emails")
    public Result updateEmail(@RequestParam("newEmail")String newEmail,@RequestParam("oldEmail")String oldEmail){
        return new Result(true,userMapper.update(null,new UpdateWrapper<User>().set("userEmail",newEmail).eq("userEmail",oldEmail)));
    }

    @PostMapping("/password")
    public Result updateEmail(@RequestParam("password")String password,@RequestParam("userID")long userID){
        return new Result(true,userMapper.update(null,new UpdateWrapper<User>().set("userpassword",password).eq("userID",userID)));
    }

    @PostMapping
    public Result insertUser(@RequestParam("userName")String username,@RequestParam("password")String password,@RequestParam("userEmail")String userEmail){
        User user = new User();
        user.setUserName(username);
        user.setUserEmail(userEmail);
        if (userMapper.selectOne(new QueryWrapper<User>().eq("userEmail",userEmail))==null) {
            userMapper.insert(user);
            return new Result(true, userMapper.update(null, new UpdateWrapper<User>().set("userpassword", password).eq("userEmail", userEmail)));
        }else{
            return new Result(true,false);
        }
    }

    @PutMapping("/{userID}")
    public Result updateUser(@PathVariable long userID,@RequestParam("userName")String userName,@RequestParam("userAge")int userAge,@RequestParam("userIntroduction")String userIntroduction){
        System.out.println(userID+userName+userAge+userIntroduction);
        User user = new User(userID,userName,userAge,userIntroduction);
        System.out.println(user);
        return new Result(true,userMapper.updateById(user));
    }

    @DeleteMapping("/{userID}")
    public Result deleteUser(@PathVariable long userID){
        return new Result(true,userMapper.deleteById(userID));
    }
}
