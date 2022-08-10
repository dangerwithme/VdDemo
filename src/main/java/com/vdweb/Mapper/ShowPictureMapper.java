package com.vdweb.Mapper;

import com.vdweb.domain.Tag;
import com.vdweb.domain.hotPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShowPictureMapper {

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,p.PictureView,p.PictureLike,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID ORDER BY p.PictureView DESC LIMIT 10")
    List<hotPicture> getHotPicture();

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,p.PictureView,p.PictureLike,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID and u.userID = #{userID}")
    List<hotPicture> getWorks(@Param("userID") long userID);

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,p.PictureView,p.PictureLike,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID and PictureID in (select pictureID from user u join user_picturecollection c on u.userID = c.userID where c.userID = #{userID})")
    List<hotPicture> getCollection(@Param("userID") long userID);

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,p.PictureView,p.PictureLike,u.userIconImage as iconImage,u.userName " +
            "from picture p,user u where p.UserID = u.userID and p.PictureTitle " +
            "REGEXP #{condition}")
    List<hotPicture> searchPicture(@Param("condition")String condition);

    @Select("select p.* from\n" +
            "(SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,p.PictureView,p.PictureLike,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID) p \n" +
            "join picturetag pt on p.PictureID = pt.pictureID \n" +
            "join tag t on t.tagID = pt.tagID \n" +
            "where pt.tagID = #{tagID}")
    List<hotPicture> useTagSearchPicture(@Param("tagID")long tagID);

}
