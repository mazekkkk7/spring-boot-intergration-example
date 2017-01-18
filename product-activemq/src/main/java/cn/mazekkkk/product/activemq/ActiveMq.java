package cn.mazekkkk.product.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by maze on 17/1/18.
 */
@Component
public class ActiveMq {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("sample.topic");
    }
}
