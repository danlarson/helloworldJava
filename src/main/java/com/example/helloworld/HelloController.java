package com.example.helloworld;

import com.example.helloworld.data.Greeting;
import com.example.helloworld.services.IGreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    private final IGreetingService greetingService;

    public HelloController(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public Greeting HelloWorld()
    {
        return greetingService.Greet();
    }
}
