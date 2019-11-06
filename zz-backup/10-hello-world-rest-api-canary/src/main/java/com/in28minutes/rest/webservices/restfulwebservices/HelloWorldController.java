package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/")
	public String helloWorldroot() {
		System.out.println("Reached V2 of Helloworld controller");
		return "Hello World root V2";
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		System.out.println("Reached V2 of Helloworld controller");
		float chance = new Random().nextFloat();
		if (chance <= 0.60f)
			throw new RuntimeException("error");
		return "Hello World - V2";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello World");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
