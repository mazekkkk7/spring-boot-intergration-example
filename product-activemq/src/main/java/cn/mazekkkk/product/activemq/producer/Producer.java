/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mazekkkk.product.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;

@Component
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Scheduled(fixedRate = 5000)
	public void run() throws Exception {
		send("Sample message");
		System.out.println("Message was sent to the Queue");
	}

	public void send(String msg) {
		Queue queue = new Queue() {
			@Override
			public String getQueueName() throws JMSException {
				return "text";
			}
		};
		this.jmsMessagingTemplate.convertAndSend(queue, msg);
	}

}
