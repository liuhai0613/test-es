package com.pkulaw.tec.controller;

import com.pkulaw.tec.service.IndexOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhai on 2020/11/28 22:01
 */
@RestController
@RequestMapping("index")
public class IndexOperateController {
    @Autowired
    IndexOperateService indexOperateService;
    @GetMapping("create")
    public void createIndex(){
        indexOperateService.createIndex();
    }
}
