package com.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Words)表实体类
 *
 * @author makejava
 * @since 2024-05-19 19:54:25
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("words")
public class Words extends Model<Words> {

    private Integer id;

    private String english;
//单词等级
    private Integer levles;
//中文
    private String cn;
//是否记住
    private Integer rem;
//不记得次数
    private Integer times;
    //背单词
    //状态码 记住，不记得，模糊，未出现
    private Integer  state = 1;





}

