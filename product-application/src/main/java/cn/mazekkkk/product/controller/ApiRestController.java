package cn.mazekkkk.product.controller;

import cn.mazekkkk.product.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maze on 17/6/13.
 */
@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private SUserService sUserService;

    @RequestMapping("/users")
    public Object all(){
        return sUserService.findAll();
    }

}
