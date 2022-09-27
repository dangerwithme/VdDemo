package com.vdweb.Controller;

import com.alibaba.fastjson.JSON;
import com.vdweb.Service.PictureService;
import com.vdweb.Service.UserService;
import com.vdweb.Service.pictureCommentService;
import com.vdweb.domain.Result;
import com.vdweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private pictureCommentService pictureCommentService;

    @Autowired
    private PictureService pictureService;

    @GetMapping("/NormalUser/{PageNum}")
    public Result getNormalUser(@PathVariable Integer PageNum){
        return new Result(true,userService.getNormalUser(PageNum,7));
    }

    @PutMapping("/NormalUser")
    public Result updateNormalUser(@RequestParam String user){
        User user1 = JSON.parseObject(user,User.class);
        return new Result(true,userService.updateUserinfo(user1));
    }

    @GetMapping("/Comments/{PageNum}")
    public Result getComment(@PathVariable Integer PageNum){
        return new Result(true,pictureCommentService.getManagePageComment(PageNum));
    }

    @DeleteMapping("/Comments")
    public Result delComment(@RequestParam long CommentID,@RequestParam long parentID){
        return new Result(true,pictureCommentService.delComment(CommentID,parentID));
    }

    @GetMapping("/Pictures/{PageNum}")
    public Result getPictures(@PathVariable Integer PageNum){
        return new Result(true,pictureService.getAllPictureByMange(PageNum));
    }

    @DeleteMapping("/Pictures")
    public Result delPicture(@RequestParam long pictureID){
        return new Result(true,pictureService.deletePicture(pictureID));
    }
}
