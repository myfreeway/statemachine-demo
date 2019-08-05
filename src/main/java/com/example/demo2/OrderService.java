package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	@Autowired
	private OrderStateMachineFactory orderStateMachineFactory;

	public String pay() {
		String result = "fail";
		OrderState CurrentState = OrderState.CREATED;
		OrderStateContext orderStateContext = new OrderStateContext();
		orderStateContext.setOrderId(1);
		orderStateContext.setExtendObject("asfasdfdsf");
		OrderStateMachine ordersm = orderStateMachineFactory.create(CurrentState);
		ordersm.start();
		log.info("sm={}, current state={}", ordersm.toString(), ordersm.getCurrentState());
		ordersm.fire(OrderEvent.PAY, orderStateContext);
		log.info("sm={}, current state={}", ordersm.toString(), ordersm.getCurrentState());
		result = "ok";
		return result;
	}
	
	public String perform() {
		String result = "fail";
		OrderState CurrentState = OrderState.PAID;
		OrderStateContext orderStateContext = new OrderStateContext();
		orderStateContext.setOrderId(1);
		orderStateContext.setExtendObject("asfasdfdsf");
		OrderStateMachine ordersm = orderStateMachineFactory.create(CurrentState);
		ordersm.start();
		log.info("sm={}, current state={}", ordersm.toString(), ordersm.getCurrentState());
		ordersm.fire(OrderEvent.PERFORM, orderStateContext);
		log.info("sm={}, current state={}", ordersm.toString(), ordersm.getCurrentState());
		result = "ok";
		return result;
	}
}
