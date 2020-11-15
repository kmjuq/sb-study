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
 * @author mengjian.ke@hand-china.com 2020/11/5 21:09
 */
@Slf4j
@Component
public class LogConsumer {

    @RabbitListener(queues = {CommonConstant.QUEUE_LOG})
    public void logForAll(Message message){
        log.info("日志消费者接收到了消息，内容为：[{}]",message);
    }

    @RabbitListener(queues = {CommonConstant.QUEUE_LOG_ERROR})
    public void logForError(Message message){
        log.info("错误日志消费者接收到了消息，内容为：[{}]",message);
    }

}
