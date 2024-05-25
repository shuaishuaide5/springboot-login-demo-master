package com.springboot.domain.DTO;

import com.springboot.domain.entity.Words;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegerListDTO {
    private List<Words> numbers;
  
    // 构造器、getter和setter方法（省略）  
  
    // 通常，还会添加验证注解（如@NotNull, @Size等）来确保数据的有效性  
}