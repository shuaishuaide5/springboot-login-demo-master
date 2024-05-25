package com.springboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVo {
    private Integer uid;
    private Integer time;//分钟
    private String sessionId;
}
