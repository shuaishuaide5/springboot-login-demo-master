package com.springboot.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.Record;

/**
 * 用于记录每一次考试成绩和记录(Record)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-24 11:51:59
 */
public interface RecordDao extends BaseMapper<Record> {

}

