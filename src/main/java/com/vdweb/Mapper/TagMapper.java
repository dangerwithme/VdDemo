package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select t.* from picturetag p, tag t where p.tagID = t.tagID and p.pictureID = #{pictureID}")
    List<Tag> selectPictureTag(@Param("pictureID") long PictureID);

    @Update("update tag SET tagHot = tagHot + 1 where tagID = #{tagID}")
    boolean addTagHot(@Param("tagID")long tagID);

}
