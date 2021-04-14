package org.hyosung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HyoSungController {


    @GetMapping("hello")
    public String hello() throws Exception {

        return "hello";
    }


}
