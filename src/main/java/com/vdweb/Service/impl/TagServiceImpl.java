package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.TagMapper;
import com.vdweb.Mapper.pictureTagMapper;
import com.vdweb.Service.TagService;
import com.vdweb.domain.Tag;
import com.vdweb.domain.pictureTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private pictureTagMapper pictureTagMapper;

    @Override
    public List<Tag> postPictureGetTag() {
        return tagMapper.selectList(new QueryWrapper<Tag>().orderByDesc("tagHot").last("limit 20"));
    }

    @Override
    public List<Tag> getCurrentPictureTag(long pictureID) {
        return tagMapper.selectPictureTag(pictureID);
    }

    @Override
    public int addTagAndAddPictureTag(long pictureID,String tagName) {
        Tag tag = tagMapper.selectOne(new QueryWrapper<Tag>().eq("tagName",tagName));
        if(tag==null) {
            tagMapper.insert(new Tag(tagName));
            tag = tagMapper.selectOne(new QueryWrapper<Tag>().eq("tagName",tagName));
        }
        tagMapper.addTagHot(tag.getTagID());
        if(pictureTagMapper.selectOne(new QueryWrapper<pictureTag>().eq("tagID",tag.getTagID()).eq("pictureID",pictureID))!=null){
            return 0;
        }else
            return pictureTagMapper.insert(new pictureTag(pictureID,tag.getTagID()));
    }
}
