package com.springboot.controller;

import com.springboot.domain.entity.Enbook;
import com.springboot.domain.entity.ResponseResult;
import com.springboot.domain.entity.Result;
import com.springboot.service.NumSelService;
import com.springboot.service.ReciteService;
import com.springboot.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class SelectController {
    @Autowired
    private SelectService selectService;
    @Autowired
    private NumSelService numSelService;
    @Autowired
    private ReciteService reciteService;
    @ResponseBody
    @RequestMapping("/Menu")
    private Result selectBook() {
        return selectService.selectBook();
    }
    @ResponseBody
    @RequestMapping("/Menu/{number}")
    private Result selectNum(@PathVariable Integer number) {
        return numSelService.selectNum(number);
    }
    @ResponseBody
    @RequestMapping("/Menu/recite")
    private ResponseResult recite(@RequestBody Enbook enbook) {
        return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
}
