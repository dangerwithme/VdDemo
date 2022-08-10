package com.vdweb.Service;

import com.vdweb.domain.Tag;

import java.util.List;

public interface TagService {
    List<Tag> postPictureGetTag();
    List<Tag> getCurrentPictureTag(long pictureId);
    int addTagAndAddPictureTag(long pictureID, String tagName);
}
