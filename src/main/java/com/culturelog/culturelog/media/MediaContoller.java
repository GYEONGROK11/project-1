package com.culturelog.culturelog.media;

import com.culturelog.culturelog.common.ResVo;
import com.culturelog.culturelog.media.model.DelMediaDto;
import com.culturelog.culturelog.media.model.InsMediaDto;
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

    @Operation(summary = "날짜별 리스트",description = "날짜별 리스트")
    @GetMapping("/day")
    public List<SelMediaDayVo> getDayMedia(@RequestBody SelMediaDayDto dto){
        return service.getDayMedia(dto);
    }

    @Operation(summary = "상세페이지",description = "상세페이지")
    @GetMapping("/{imedia}")
    public SelDetailMediaVo getDetailMedia(@PathVariable int imedia, int iuser){
        return service.getDetailMedia(imedia,iuser);
    }

    @Operation(summary = "시청여부에 따른 페이지",description = "시청여부에 따른 페이지")
    @GetMapping
    public List<SelMediaVo> getMedia(int iuser, int isSaw){
        return service.getMedia(iuser,isSaw);
    }

    @Operation(summary = "미디어 등록",description = "미디어 등록")
    @PostMapping
    public ResVo postMedia(@RequestBody InsMediaDto dto){
        return service.postMedia(dto);
    }

    @Operation(summary = "미디어 수정",description = "미디어 수정")
    @PutMapping
    public ResVo putMedia(@RequestBody PutMedia dto){
        return service.putMedia(dto);
    }

    @Operation(summary = "미디어 삭제",description = "미디어 삭제")
    @DeleteMapping
    public ResVo delMedia(@RequestBody DelMediaDto dto){
        return service.delMedia(dto);
    }
}
