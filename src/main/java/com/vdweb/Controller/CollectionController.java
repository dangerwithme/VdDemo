package com.vdweb.Controller;

import com.vdweb.Service.CollectionService;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collections")
public class CollectionController {

    @Autowired
    private CollectionService CollectionService;

    @DeleteMapping
    public Result delCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,CollectionService.delCollection(pictureID,userID));
    }

    @PostMapping
    public Result insertCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,CollectionService.insertCollection(pictureID,userID));
    }

    @GetMapping
    public Result getCollection(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return new Result(true,CollectionService.IsItCollection(pictureID,userID));
    }

}
