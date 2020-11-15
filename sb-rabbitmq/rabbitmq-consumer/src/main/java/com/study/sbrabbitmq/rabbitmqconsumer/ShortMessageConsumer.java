package com.study.sbrabbitmq.rabbitmqconsumer;

import com.study.sbrabbitmq.rabbitmqcommon.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/5 17:36
 */
@Slf4j
@Component
public class ShortMessageConsumer {

    @RabbitListener(queues = {CommonConstant.QUEUE_SHORT_MESSAGE_1})
    public void shortMessageConsumer1(Message message){
        log.info("短信接受端1，接受消息为[{}]",message.toString());
    }

    @RabbitListener(queues = {CommonConstant.QUEUE_SHORT_MESSAGE_2})
    public void shortMessageConsumer2(Message message){
        log.info("短信接受端2，接受消息为[{}]",message.toString());
    }

    @RabbitListener(queues = {CommonConstant.QUEUE_SHORT_MESSAGE_3})
    public void shortMessageConsumer3(Message message){
        log.info("短信接受端3，接受消息为[{}]",message.toString());
    }

}
