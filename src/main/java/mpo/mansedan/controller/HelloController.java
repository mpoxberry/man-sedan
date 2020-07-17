package mpo.mansedan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @GetMapping(value = "/greeting")
    public String helloWorld() {
	return "Hello world!";
    }

    @GetMapping(value = "/greeting/hello/{name}")
    public String helloBack(@PathVariable(value = "name") String name) {
	return "Hello world " + name.replace(name.charAt(0), name.toUpperCase()
		.charAt(0)) + "!";
    }
}
