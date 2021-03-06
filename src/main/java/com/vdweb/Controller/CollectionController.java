package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.CollectionMapper;
import com.vdweb.domain.Result;
import com.vdweb.domain.user_pictureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collections")
public class CollectionController {

    @Autowired
    private CollectionMapper collectionMapper;

    @DeleteMapping
    public Result delCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,collectionMapper.delete(new QueryWrapper<user_pictureCollection>().eq("pictureID",pictureID).eq("userID",userID)));
    }

    @PostMapping
    public Result insertCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        user_pictureCollection collection = new user_pictureCollection(pictureID,userID);
        return new Result(true,collectionMapper.insert(collection));
    }

    @GetMapping
    public Result getCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,collectionMapper.selectOne(new QueryWrapper<user_pictureCollection>().eq("pictureID",pictureID).eq("userID",userID))!=null);
    }

}
