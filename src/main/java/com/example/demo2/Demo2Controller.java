package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Demo2Controller {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/pay")
	public String pay() {
		String result = "fail";
		try {
			result = orderService.pay();
		} catch (Exception e) {
			
		}
		return result;
	}

	@GetMapping(value = "/perform")
	public String perform() {
		String result = "fail";
		result = orderService.perform();
		return result;
	}
}
