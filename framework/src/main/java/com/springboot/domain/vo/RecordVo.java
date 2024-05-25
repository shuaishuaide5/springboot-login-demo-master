package com.springboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordVo {
    private Integer id; private Integer uid; private Boolean trueORfalse;//对或错
}
