package com.example.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

import com.example.demo2.handler.OrderDefaultHandler;

import lombok.extern.slf4j.Slf4j;

@StateMachineParameters(stateType = OrderState.class, eventType = OrderEvent.class, contextType = OrderStateContext.class)
@Slf4j
public class OrderStateMachine extends AbstractUntypedStateMachine {

	private ApplicationContext applicationContext;

	// 定义构造函数接受ApplicationContext注入([参看New State Machine
	// Instance](http://hekailiang.github.io/squirrel/))
	public OrderStateMachine(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void onPay(OrderState from, OrderState to, OrderEvent event, OrderStateContext context) {
		log.info("from={}, to={}, event={}, context={}", from, to, event, context);
		// 先get handler map。key=状态机Id+业务类型+事件名
		// 从map里get handler。如果null，则使用本状态机默认的handler
		OrderDefaultHandler orderDefaultHandler = applicationContext.getBean(OrderDefaultHandler.class);
		orderDefaultHandler.updateState(from, to, event, context);
	}

	public void onPerform(OrderState from, OrderState to, OrderEvent event, OrderStateContext context) {
		log.info("from={}, to={}, event={}, context={}", from, to, event, context);
	}

}
