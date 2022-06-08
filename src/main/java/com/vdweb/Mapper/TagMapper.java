package com.vdweb.Mapper;

import com.vdweb.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("select tagName from picturetag p, tag t where p.tagID = t.tagID and p.pictureID = #{pictureID}")
    List<Tag> selectPictureTag(@Param("pictureID") long PictureID);

}
