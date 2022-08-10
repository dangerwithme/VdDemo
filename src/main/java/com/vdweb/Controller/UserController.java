package com.vdweb.Controller;

import com.vdweb.Service.UserService;
import com.vdweb.domain.Result;
import com.vdweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Integer id){
        return new Result(true,userService.getUserInfo(id));
    }

    @GetMapping("/login")
    public Result login(@RequestParam("account") String username,@RequestParam("password") String password){
        return userService.login(username,password);
    }

    @GetMapping("/Emails")
    public Result getEmail(@RequestParam("email")String userEmail){
        return new Result(true,userService.EmailIsUsing(userEmail));
    }

    @PostMapping("/Emails")
    public Result updateEmail(@RequestParam("newEmail")String newEmail,@RequestParam("oldEmail")String oldEmail){
        return new Result(true,userService.updateEmail(newEmail, oldEmail));
    }

    @PostMapping("/password")
    public Result updatePassword(@RequestParam("password")String password,@RequestParam("userID")long userID){
        return new Result(true,userService.updatePassword(password, userID));
    }

    @PostMapping
    public Result insertUser(@RequestParam("userName")String username,@RequestParam("password")String password,@RequestParam("userEmail")String userEmail){
        return userService.Register(username,password,userEmail);
    }

    @PutMapping("/{userID}")
    public Result updateUser(@PathVariable long userID,@RequestParam("userName")String userName,@RequestParam("userAge")int userAge,@RequestParam("userIntroduction")String userIntroduction){
        System.out.println(userID+userName+userAge+userIntroduction);
        User user = new User(userID,userName,userAge,userIntroduction);
        System.out.println(user);
        return new Result(true,userService.updateUserinfo(user));
    }

    @DeleteMapping("/{userID}")
    public Result deleteUser(@PathVariable long userID){
        return new Result(true,userService.deleteUser(userID));
    }

    @GetMapping("/search")
    public Result getSearchResult(@RequestParam("condition")String condition){
        return new Result(true,userService.EasySearch(condition));
    }
}
