package com.springboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordsVo {
    private Integer id;

    private String English;
    //单词等级
    private String book;
    //中文
    private String Chinese;
    //不记得次数
    private Integer testTimes;
    //背单词
    //状态码 记住，不记得，模糊，未出现
    private boolean remember ;
}
