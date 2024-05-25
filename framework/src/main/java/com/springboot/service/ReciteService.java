package com.springboot.service;

import com.springboot.domain.entity.Result;

public interface ReciteService {
    Result recite(boolean state, Integer id, Integer uid);
}
