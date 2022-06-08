package com.vdweb.Controller;

import com.vdweb.Mapper.followMapper;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follows")
public class followController {

    @Autowired
    private followMapper followMapper;

    @PostMapping
    public Result follow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true,followMapper.insert(followID,followedID));
    }

    @GetMapping
    public Result getFollow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true,followMapper.selectOne(followID,followedID)!=null);
    }

    @DeleteMapping
    public Result delFollow(@RequestParam("followerID")long followID, @RequestParam("followedID")long followedID){
        return new Result(true,followMapper.deleteOne(followID,followedID));
    }
}
