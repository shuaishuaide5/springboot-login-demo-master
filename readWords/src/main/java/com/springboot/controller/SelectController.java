package com.springboot.controller;

import com.springboot.domain.entity.Enbook;
import com.springboot.domain.entity.ResponseResult;
import com.springboot.service.NumSelService;
import com.springboot.service.ReciteService;
import com.springboot.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SelectController {
    @Autowired
    private SelectService selectService;
    @Autowired
    private NumSelService numSelService;
    @Autowired
    private ReciteService reciteService;
    @RequestMapping("/Menu")
    private ResponseResult selectBook() {
        return selectService.selectBook();
    }

    @RequestMapping("/Menu/{number}")
    private ResponseResult selectNum(@PathVariable Integer number) {
        return numSelService.selectNum(number);
    }

    @RequestMapping("/Menu/recite")
    private ResponseResult recite(@RequestBody Enbook enbook) {
        return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
}
