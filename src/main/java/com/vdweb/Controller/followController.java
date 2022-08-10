package com.vdweb.Controller;

import com.vdweb.Service.FollowService;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follows")
public class followController {

    @Autowired
    private FollowService followService;

    @PostMapping
    public Result follow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true, followService.FollowSomeOne(followID, followedID));
    }

    @GetMapping
    public Result getFollow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true,followService.IsItFollowing(followID,followedID));
    }

    @DeleteMapping
    public Result delFollow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true,followService.UnFollowSomeOne(followID,followedID));
    }
}
