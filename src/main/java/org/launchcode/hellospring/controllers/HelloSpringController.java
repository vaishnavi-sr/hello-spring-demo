package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloSpringController {
    // responds to get requests at "/hello"
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
//     responds to post request at "/goodbye"
    @PostMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    // responds to get and post request at "/helloGoodBye"
    @RequestMapping(value = "helloGoodBuy",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String helloGoodBye(){
        return "Hello! Goodbye Spring!";

    }


}
