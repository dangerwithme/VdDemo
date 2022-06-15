package com.vdweb.Mapper;

import com.vdweb.domain.Tag;
import com.vdweb.domain.hotPicture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShowPictureMapper {

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID ORDER BY p.PictureLike DESC LIMIT 10")
    List<hotPicture> getHotPicture();

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID and u.userID = #{userID}")
    List<hotPicture> getProduction(@Param("userID") long userID);

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID and PictureID in (select pictureID from user u join user_picturecollection c on u.userID = c.userID where c.userID = #{userID})")
    List<hotPicture> getCollection(@Param("userID") long userID);

    @Select("select tagName from picturetag p, tag t where p.tagID = t.tagID and p.pictureID = #{pictureID}")
    List<Tag> selectPictureTag(@Param("pictureID") long PictureID);

    @Select("SELECT p.PictureID,p.PicturePath,p.PictureTitle,u.userID as authorID,u.userIconImage as iconImage,u.userName from picture p,user u where p.UserID = u.userID and p.PictureTitle like CONCAT('%',#{condition},'%')")
    List<hotPicture> searchPicture(@Param("condition")String condition);

}
