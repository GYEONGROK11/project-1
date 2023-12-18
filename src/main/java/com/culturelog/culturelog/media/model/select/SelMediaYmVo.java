package com.culturelog.culturelog.media.model.select;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SelMediaYmVo {
    @Schema(title = "날짜")
    private String day;
    @Schema(title = "미디어 사진")
    private String pic;
    @Schema(title = "미디어 번호 리스트")
    private List<Integer> imedia;

}
