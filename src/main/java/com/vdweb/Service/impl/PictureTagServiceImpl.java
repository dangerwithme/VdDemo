package com.vdweb.Service.impl;

import com.vdweb.Mapper.pictureTagMapper;
import com.vdweb.Service.PictureTagService;
import com.vdweb.domain.pictureTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PictureTagServiceImpl implements PictureTagService {

    @Autowired
    private pictureTagMapper pictureTagMapper;

    @Override
    public int insertPictureTag(long pictureID, long tagID) {
        return pictureTagMapper.insert(new pictureTag(pictureID,tagID));
    }
}
