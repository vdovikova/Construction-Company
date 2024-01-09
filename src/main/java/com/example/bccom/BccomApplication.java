package com.example.bccom;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
@SpringBootApplication
@ComponentScan({"com.example.bccom.controllers", "com.example.bccom.models", "com.example.bccom.services",
		"com.example.bccom.repo"})
public class BccomApplication {

	public static void main(String[] args) { SpringApplication.run(BccomApplication.class, args);}

}
