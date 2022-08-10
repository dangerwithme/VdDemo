package com.vdweb.Controller;

import com.vdweb.Service.PictureService;
import com.vdweb.Service.pictureCommentService;
import com.vdweb.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private pictureCommentService pictureCommentService;

    @GetMapping("getHotPicture")
    public Result getHotPicture(){
        return new Result(true,pictureService.getHotPictureInfo());
    }

    @GetMapping("getWorks/{userID}")
    public Result getWorks(@PathVariable long userID){
        return new Result(true,pictureService.getPersonalWorks(userID));
    }

    @GetMapping("getCollection/{userID}")
    public Result getCollection(@PathVariable long userID){
        return new Result(true,pictureService.getCollectionWorks(userID));
    }

    @DeleteMapping("/UserManageWorks")
    public Result UserSelfDel(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
        return pictureService.delPersonalWorks(pictureID,userID);
    }

    @PostMapping
    public Result insertPicture(long userID,MultipartFile picture,String pictureTitle){
        return pictureService.PostPicture(userID,picture,pictureTitle);
    }

    @GetMapping("/search")
    public Result getSearchResult(@RequestParam("condition")String condition){
        return new Result(true,pictureService.EasySearch(condition));
    }

    @PutMapping("/views")
    public Result addPictureViews(@RequestParam("pictureID")long pictureID){
        return new Result(true,pictureService.addPictureView(pictureID));
    }

    @GetMapping("/tagSearch")
    public Result SearchPictureByTagName(@RequestParam("tagID")long tagID){
        return new Result(true,pictureService.userTagIDSearchPicture(tagID));
    }

    @GetMapping("/comments/{pageNum}")
    public Result GetCurrentPictureComment(@RequestParam("pictureID")long pictureID,@PathVariable Integer pageNum){
        return new Result(true,pictureCommentService.getCurrentPictureComment(pictureID,pageNum,5));
    }

    @PostMapping("/comments")
    public Result PostComment(@RequestParam("userID")long userID,@RequestParam("pictureID")long pictureID,@RequestParam("parentID")long parentID,@RequestParam("content")String content){
        return new Result(true,pictureCommentService.postComment(userID,pictureID,parentID,content));
    }

}
