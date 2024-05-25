package com.springboot.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.domain.entity.UserWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * (UserWords)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-25 10:25:41
 */
@Repository
public interface UserWordsDao extends JpaRepository<UserWords, Long> {

}

