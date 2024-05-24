package com.springboot.service;

import com.springboot.domain.entity.ResponseResult;
import com.springboot.domain.entity.Result;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SelectService {
     Result selectBook();
}
