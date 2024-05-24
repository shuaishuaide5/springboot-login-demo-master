package com.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 检测用户是否在考试(Iftest)表实体类
 *
 * @author makejava
 * @since 2024-05-24 23:25:40
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("iftest")
public class Iftest extends Model<Iftest> {

    private Integer id;
//考试状态
    private String test;



}

