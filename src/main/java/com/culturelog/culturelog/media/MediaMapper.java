package com.culturelog.culturelog.media;


import com.culturelog.culturelog.media.model.DelMediaDto;
import com.culturelog.culturelog.media.model.InsMediaDto;
import com.culturelog.culturelog.media.model.PatchIsSawDto;
import com.culturelog.culturelog.media.model.PutMedia;
import com.culturelog.culturelog.media.model.select.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MediaMapper {

    int postMedia(InsMediaDto dto);

    int postMediaPics(InsMediaDto dto);

    int patchIsSaw(PatchIsSawDto dto);

    int putMedia(PutMedia dto);

    int DelMediaPics(DelMediaDto dto);

    int DelMedia(DelMediaDto dto);

    Integer selMediaByUser(DelMediaDto dto);

    List<SelMediaYmVo> getMediaAll(SelMediaYmDto dto);

    List<Integer> getMediaImedia(SelMediaYmDto dto);

    List<SelMediaDayVo> getDayMedia(SelMediaDayDto dto);

    SelDetailMediaVo getDetailMedia(int imedia, int iuser);

    List<String> getDetailMediaPics(int imedia);

    List<SelMediaVo> getMedia(int iuser, int isSaw);

}
