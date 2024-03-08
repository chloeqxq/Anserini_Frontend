package com.example.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// http协议，
// 类型（method）：GET, POST, PUT, PATCH， DELETE
// host: http://localhost:18080
// query params: ?xxxxxx
// request body: application/json

// http://localhost:18080/searh/doSearch?keywords="2024"

//response: { "name": "xiaoming", "age": 29}

@RestController
@RequestMapping("/search")
public class DoSearch {

    @GetMapping("/doSearch")
    public String doSearch(@RequestParam("keywords")String keywords) {
//        String a = serini.search(keywords);
//        return a;
          return "";
    }
}
