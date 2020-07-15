package mpo.mansedan;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/gretting")
    public String helloWorld() {
	return "Hello world";
    }
}
