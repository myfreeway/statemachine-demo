package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.web.bind.annotation.RestController;
import org.squirrelframework.foundation.fsm.StateMachineContext;
import org.squirrelframework.foundation.fsm.annotation.State;

@RestController
public class DemoController {

	@Autowired
	private DiscountRefundStateMachineEngine discountRefundStateMachineEngine;
	public String applyConfirm(){
		String result = "fail";
//		int rmaId = 1;
//		State initialState = new ;
//		Trigger trigger;
//		StateMachineContext context;
//		discountRefundStateMachineEngine.fire(rmaId, initialState, trigger, context);
		return result;
	}
}
