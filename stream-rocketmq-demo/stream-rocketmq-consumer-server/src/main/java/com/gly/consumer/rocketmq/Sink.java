package com.gly.consumer.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

	@Input("input1")
	SubscribableChannel input1();

	@Input("input2")
	SubscribableChannel input2();

	@Input("input3")
	SubscribableChannel input3();

	@Input("input4")
	SubscribableChannel input4();

	@Input("input5")
	PollableMessageSource input5();


}
