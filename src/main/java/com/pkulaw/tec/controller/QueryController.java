package com.pkulaw.tec.controller;

import com.pkulaw.tec.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuhai on 2020/11/27 18:34
 */
@RestController
public class QueryController {
    @Autowired
    QueryService queryService;

    @GetMapping("/esQueryTest1")
    public Object esQueryTest1(){
        return queryService.esQueryTest1();
    }
}
