package controller;

import com.springboot.domain.entity.ResponseResult;
import com.springboot.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class SelectController {
    @Autowired
    private SelectService selectService;
    @RequestMapping("Mune")
    private ResponseResult selectBook(@PathVariable Integer levels) {
        return selectService.selectBook(levels);
    }
}
