package com.culturelog.culturelog.media.model.select;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@Schema(title = "메인 페이지 출력 데이터")
public class SelMediaYmDto {
    @Schema(title = "년도")
    private String year;
    @Schema(title = "월")
    private String month;
    @JsonIgnore
    private String day;
    @Schema(title = "유저번호")
    private int iuser;
}
