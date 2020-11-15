package com.study.sbrabbitmq.rabbitmqconsumer;

import com.study.sbrabbitmq.rabbitmqcommon.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/5 13:04
 */
@Slf4j
@Component
public class EmailConsumer {

    @RabbitListener(queues = {CommonConstant.QUEUE_EMAIL})
    public void emailConsumer1(Message message) {
        log.info("邮件消费者1接收到的消息：[{}]", message.toString());
    }

    @RabbitListener(queues = {CommonConstant.QUEUE_EMAIL})
    public void emailConsumer2(Message message) {
        log.info("邮件消费者2接收到的消息：[{}]", message.toString());
    }

}
