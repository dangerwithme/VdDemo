package com.vdweb.Controller;

import com.vdweb.Service.UserLikeService;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserLikes")
public class UserLikeController {
    
    @Autowired
    private UserLikeService UserLikeService;

    @DeleteMapping
    public Result delUserLike(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,UserLikeService.delLike(pictureID,userID));
    }

    @PostMapping
    public Result insertUserLike(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,UserLikeService.insertLike(pictureID,userID));
    }

    @GetMapping
    public Result getUserLike(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,UserLikeService.IsItLike(pictureID,userID));
    }
}
