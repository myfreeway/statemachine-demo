package com.example.demo2.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo2.OrderEvent;
import com.example.demo2.OrderState;
import com.example.demo2.OrderStateContext;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderDefaultHandler {
	public boolean guard(){
		return true;
	}
	
	// 根据name来get handler。name=状态机Id+业务类型+事件名
	public String getName(){
		return null;
	}

	public void updateState(OrderState from, OrderState to, OrderEvent event, OrderStateContext context) {
		log.info("from={}, to={}, event={}, context={}", from, to, event, context);
		log.info("do updateState by DI bean");
		int i=1/0;
	}

}
