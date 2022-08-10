package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.pictureComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface pictureCommentMapper extends BaseMapper<pictureComment> {

    @Select("select * from picturecomment where pictureID = #{pictureID} and parentID = 0")
    @Results(id = "pictureCommentMap",value = {
            @Result(id = true,column = "commentID",property = "commentID"),
            @Result(column = "commentUserID",property = "commentUserID"),
            @Result(property = "commentUser",column = "commentUserID",
                    one = @One(select = "com.vdweb.Mapper.UserMapper.getCommentUser",fetchType = FetchType.DEFAULT)),
            @Result(column = "content",property = "content"),
            @Result(column = "pictureID",property = "pictureID"),
            @Result(property = "children",column = "commentID",many = @Many(select = "com.vdweb.Mapper.pictureCommentMapper.selectChildrenCommentByParentID",fetchType = FetchType.DEFAULT))
    })
    List<pictureComment> selectComment(@Param("pictureID") long pictureID);

    @Select("select * from picturecomment where parentID = #{parentID}")
    @ResultMap("pictureCommentMap")
    List<pictureComment> selectChildrenCommentByParentID(@Param("parentID") long parentID);

}
