package com.springboot.controller;

import com.springboot.domain.entity.Enbook;
import com.springboot.domain.entity.ResponseResult;
import com.springboot.domain.entity.Result;
import com.springboot.domain.vo.RecordVo;
import com.springboot.service.NumSelService;
import com.springboot.service.ReciteService;
import com.springboot.service.SelectService;
import com.springboot.service.TestService;
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
    @Autowired
    private TestService testService;
    //@ResponseBody
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
    private void recite(@RequestBody Enbook enbook) {
        reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
    @RequestMapping("/Menu/test")
    private Result test(@RequestBody int uid) {
        return testService.test(uid);
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
    @RequestMapping("/Menu/record")
    private Result record(@RequestBody RecordVo enbook) {
        int id = enbook.getId();
        int uid = enbook.getUid();
        return testService.record(uid,id);
        //return  reciteService.recite(enbook.getState(),enbook.getId(),enbook.getUid());
    }
}
