package mpo.mansedan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @GetMapping(value = "/greeting")
    public String helloWorld() {
	return "Hello world";
    }
}
