package com.example.demo;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemoBizService {

	public void doSomething() {
		log.info("has do something....");
	}
	
}
