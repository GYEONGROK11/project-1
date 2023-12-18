package com.culturelog.culturelog.media;


import com.culturelog.culturelog.common.Const;
import com.culturelog.culturelog.common.ResVo;
import com.culturelog.culturelog.media.model.DelMediaDto;
import com.culturelog.culturelog.media.model.InsMediaDto;
import com.culturelog.culturelog.media.model.PatchIsSawDto;
import com.culturelog.culturelog.media.model.PutMedia;
import com.culturelog.culturelog.media.model.select.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class MediaService {
    private final MediaMapper mapper;

    public ResVo postMedia(InsMediaDto dto){
        mapper.postMedia(dto);
        mapper.postMediaPics(dto);
        return new ResVo(dto.getImedia());
    }

    public ResVo patchIsSaw(PatchIsSawDto dto){
        mapper.patchIsSaw(dto);
        return new ResVo(Const.SUCCESS);
    }

    public ResVo putMedia(PutMedia dto){
        mapper.putMedia(dto);
        if (dto.getPics().size() > 0 && dto.getPics().size() < 5 ){
            DelMediaDto dto1 = new DelMediaDto();
            dto1.setImedia(dto.getImedia());
            mapper.DelMediaPics(dto1);
            InsMediaDto dto2 = new InsMediaDto();
            dto2.setImedia(dto.getImedia());
            dto2.setPics(dto.getPics());
            mapper.postMediaPics(dto2);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo delMedia(DelMediaDto dto){
        Integer media = mapper.selMediaByUser(dto);
        if(media == null){
            return new ResVo(Const.FAIL);
        }
        mapper.DelMedia(dto);
        return new ResVo(Const.SUCCESS);
    }

    public List<SelMediaYmVo> getMediaAll(SelMediaYmDto dto){
        List<SelMediaYmVo> vo = mapper.getMediaAll(dto);

        for (int i = 0; i < vo.size(); i++) {
            dto.setDay(vo.get(i).getDay());
            List<Integer> media = mapper.getMediaImedia(dto);
            vo.get(i).setImedia(media);
        }
        return vo;
    }

    public List<SelMediaDayVo> getDayMedia(SelMediaDayDto dto){
        return mapper.getDayMedia(dto);
    }

    public SelDetailMediaVo getDetailMedia(int imedia, int iuser){
        SelDetailMediaVo vo = mapper.getDetailMedia(imedia,iuser);
        List<String> pics = mapper.getDetailMediaPics(imedia);
        vo.setPics(pics);
        return vo;
    }

    public List<SelMediaVo> getMedia(int iuser, int isSaw){
        return mapper.getMedia(iuser, isSaw);
    }
}
