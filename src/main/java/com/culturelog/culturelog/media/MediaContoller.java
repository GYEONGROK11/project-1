package com.culturelog.culturelog.media;

import com.culturelog.culturelog.common.ResVo;
import com.culturelog.culturelog.media.model.DelMediaDto;
import com.culturelog.culturelog.media.model.InsMediaDto;
import com.culturelog.culturelog.media.model.PatchIsSawDto;
import com.culturelog.culturelog.media.model.PutMedia;
import com.culturelog.culturelog.media.model.select.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/media")
@Tag(name = "미디어 API",description = "미디어 관련 처리")
public class MediaContoller {
    private final MediaService service;

    @Operation(summary = "메인페이지",description = "메인페이지")
    @GetMapping("/ym")
    public List<SelMediaYmVo> getMediaAll(@RequestBody SelMediaYmDto dto){
        return service.getMediaAll(dto);
    }

    @Operation(summary = "날짜별",description = "메인페이지")
    @GetMapping("/day")
    public List<SelMediaDayVo> getDayMedia(@RequestBody SelMediaDayDto dto){
        return service.getDayMedia(dto);
    }

    @GetMapping("/{imedia}")
    public SelDetailMediaVo getDetailMedia(@PathVariable int imedia, int iuser){
        return service.getDetailMedia(imedia,iuser);
    }

    @GetMapping
    public List<SelMediaVo> getMedia(int iuser, int isSaw){
        return service.getMedia(iuser,isSaw);
    }


    @PostMapping
    public ResVo postMedia(@RequestBody InsMediaDto dto){
        return service.postMedia(dto);
    }

    @PatchMapping
    public ResVo patchIsSaw(@RequestBody PatchIsSawDto dto){
        return service.patchIsSaw(dto);
    }

    @PutMapping
    public ResVo putMedia(@RequestBody PutMedia dto){
        return service.putMedia(dto);
    }

    @DeleteMapping
    public ResVo delMedia(@RequestBody DelMediaDto dto){
        return service.delMedia(dto);
    }
}
