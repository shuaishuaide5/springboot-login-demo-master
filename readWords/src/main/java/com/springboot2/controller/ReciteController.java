package com.springboot2.controller;

import com.springboot.domain.myMethord.Result;
import com.springboot.domain.vo.UserWordVo;
import com.springboot.service.ReciteService;
import com.springboot.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class ReciteController {
    @Autowired
    private SelectService selectService;
    @Autowired
    private ReciteService reciteService;

    //@ResponseBody
    @CrossOrigin
    @RequestMapping("/Menu")
    private Result selectBook() {
        return selectService.selectBook();
    }
   /* @ResponseBody
    @RequestMapping("/Menu/{number}")
    private Result selectNum(@PathVariable Integer number) {
        return numSelService.selectNum(number);
    }*/
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/Menu/recite")
    private Result recite(@RequestBody UserWordVo userwordVo) {
        return reciteService.recite(userwordVo.getState(), userwordVo.getId(), userwordVo.getUid());
    }


}
