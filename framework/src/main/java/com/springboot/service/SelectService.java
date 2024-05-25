package com.springboot.service;

import com.springboot.domain.Methord.Result;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface SelectService {
     Result selectBook();
}
