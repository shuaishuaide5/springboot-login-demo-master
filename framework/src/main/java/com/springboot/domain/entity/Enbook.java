package com.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * (Enbook)表实体类
 *
 * @author makejava
 * @since 2024-05-19 19:32:52
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tableInfo.name")
public class Enbook {

    private String name;
//单词等级
    private Integer levels;
//介绍
    private String introduction;
//适用人群
    private String people;



}

