package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.Picture;
import com.vdweb.domain.hotPicture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PictureMapper extends BaseMapper<Picture> {
    @Update("update picture SET PictureView = PictureView + 1 where PictureID = #{pictureID}")
    boolean addPictureView(@Param("pictureID")long pictureID);

    @Update("update picture SET PictureLike = PictureLike + 1 where PictureID = #{pictureID}")
    boolean addPictureLike(@Param("pictureID")long pictureID);

    @Update("update picture SET PictureLike = PictureLike - 1 where PictureID = #{pictureID}")
    boolean minusPictureLike(@Param("pictureID")long pictureID);

    @Update("update picture set deleted=1 where PictureID=#{pictureID}")
    int deleteByPictureID(@Param("pictureID")long pictureID);
}
