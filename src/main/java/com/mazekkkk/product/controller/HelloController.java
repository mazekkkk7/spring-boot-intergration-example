package com.mazekkkk.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mazekkkk on 16/1/12.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "build Spring boot Success!";
    }
}
