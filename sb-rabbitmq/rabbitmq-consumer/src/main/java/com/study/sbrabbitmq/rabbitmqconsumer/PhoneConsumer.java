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
public class PhoneConsumer {

    @RabbitListener(queues = {CommonConstant.QUEUE_PHONE})
    public void onMessage(Message message) {
        log.info("电话消费者接收到的消息：[{}]", message.toString());
    }

}
