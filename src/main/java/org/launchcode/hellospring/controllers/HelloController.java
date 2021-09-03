package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Objects;

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
                "<form action='greet' method='post'>"+  //Submit request to /hello
                "Name <input type='text' name ='name'>"+
                "<label for='language'/>" +
                "<select name='language'>" +
                "<option value=''>Select Language</option>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='japan'>Japan</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='hindi'>Hindi</option>" +
                "<option value='arabic'>Arabic</option>" +
                "<option value='russia'>Russia</option>" +
                "</select>"+
                "<input type='submit' value = 'Greet Me!'>"+
                "<br>"+

                "</form>" +
                "</body>"+
                "</html>";

    }

    @RequestMapping(value="greet",method ={RequestMethod.POST})
    public String helloGreetWithLangauge(@RequestParam String name,@RequestParam String language){
       String helloGreeting="";

       if(Objects.nonNull(language) && language.equals("french"))
           helloGreeting= "bonjour";
       else if(Objects.nonNull(language) && language.equals("spanish"))
            helloGreeting= "holla";
       else if(Objects.nonNull(language) && language.equals("japan"))
            helloGreeting= "こんにちは";
       else if(Objects.nonNull(language) && language.equals("german"))
           helloGreeting= "hallo";
       else if(Objects.nonNull(language) && language.equals("hindi"))
           helloGreeting= "नमस्कार";
       else if(Objects.nonNull(language) && language.equals("arabic"))
           helloGreeting= "مرحبًا";
       else if(Objects.nonNull(language) && language.equals("russia"))
           helloGreeting= "привет";
       else
           helloGreeting = "hello";

        return helloGreeting +" , " + name + "!";
    }



}
