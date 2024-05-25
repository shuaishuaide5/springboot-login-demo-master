package com.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * (UserWords)表实体类
 *
 * @author makejava
 * @since 2024-05-25 10:25:43
 */
@SuppressWarnings("serial")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_words")
public class UserWords extends Model<UserWords> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//用户id
    private Integer userId;

    private Integer wordId;



    /**
     * 获取主键值
     *
     * @return 主键值
     */

}

