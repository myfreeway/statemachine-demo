package com.example.demo2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 *            状态机类型
 * @param <S>
 *            状态类型
 */
@Service
public abstract class AbstractStateMachineFactory<T extends UntypedStateMachine, S> implements ApplicationContextAware {
	// 子类使用父类的变量
	protected ApplicationContext applicationContext;

	// 子类使用父类的变量
	protected UntypedStateMachineBuilder builder = null;

	public AbstractStateMachineFactory() {
		// 识别泛型参数
		@SuppressWarnings("unchecked")
		Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),
				AbstractStateMachineFactory.class);
		builder = StateMachineBuilderFactory.create(genericType, ApplicationContext.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public abstract T create(S CurrentState);

}
