package com.tavant.openshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
@RestController
public class OpenShiftTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenShiftTrainingApplication.class, args);
	}

	@RequestMapping("/")
    public String welcome() throws UnknownHostException {
	    return "Hello from Docker" + InetAddress.getLocalHost().getHostName();
    }
}
