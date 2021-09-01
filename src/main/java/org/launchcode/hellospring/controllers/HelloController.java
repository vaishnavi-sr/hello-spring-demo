package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody  //as response body annotation comes in each of the method
@RequestMapping("hello")
public class HelloController {
    //Handles request in path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello Spring!";
//    }
    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye Spring!";
    }
    //    Handles request of the form /hello?name=LaunchCode
    //lives at /hello/hello
    @RequestMapping(method ={RequestMethod.GET,RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
   //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>"+
                "<form action='hello' method='post'>"+  //Submit request to /hello
                "<input type='text' name ='name'>"+
                "<input type='submit' value = 'Greet Me!'>"+
                "</form>" +
                "</body>"+
                "</html>";

    }



}
