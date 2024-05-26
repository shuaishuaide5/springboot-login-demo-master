package com.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用于记录每一次考试成绩和记录(Record)表实体类
 *
 * @author makejava
 * @since 2024-05-24 11:40:48
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("record")
public class Record extends Model<Record> {
//考试编号
    private Integer id;
//总分
    private Integer goal;
//用户的考试时间
    private Instant time;
//用字符串表示考试情况
    private String sum;




}

