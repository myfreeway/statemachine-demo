package com.example.demo2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

@Service
public class OrderStateMachineFactory extends AbstractStateMachineFactory<OrderStateMachine, OrderState> {
	public OrderStateMachineFactory() {
		super();
		builder.externalTransition().from(OrderState.CREATED).to(OrderState.PAID).on(OrderEvent.PAY)
				.callMethod("onPay");
		builder.externalTransition().from(OrderState.PAID).to(OrderState.PERFORMED).on(OrderEvent.PERFORM);
		builder.externalTransition().from(OrderState.PERFORMED).to(OrderState.FINISH).on(OrderEvent.COMMENT);
		builder.externalTransition().from(OrderState.PERFORMED).to(OrderState.FINISH)
				.on(OrderEvent.COMMENT_OVERTIME_CANCEL);
		builder.externalTransition().from(OrderState.CREATED).to(OrderState.CLOSED).on(OrderEvent.CANCEL);
		builder.externalTransition().from(OrderState.CREATED).to(OrderState.CLOSED).on(OrderEvent.PAY_OVERTIME_CANCEL);
	}

	@Override
	public OrderStateMachine create(OrderState CurrentState) {
		// 暂时开启debug进行日志trace
		StateMachineConfiguration smConfig = StateMachineConfiguration.create();
		smConfig = smConfig.enableDebugMode(true).enableAutoStart(true);
		// 注入applicationContext
		OrderStateMachine sm = builder.newUntypedStateMachine(CurrentState, smConfig, applicationContext);
		return sm;
	}

}
