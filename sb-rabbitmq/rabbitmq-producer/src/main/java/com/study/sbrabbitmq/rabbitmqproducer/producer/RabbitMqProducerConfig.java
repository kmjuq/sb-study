package com.study.sbrabbitmq.rabbitmqproducer.producer;

import com.study.sbrabbitmq.rabbitmqcommon.CommonConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 假设生产者是注册系统。
 * 消费者是邮件系统，短信系统,
 * 邮件系统，短信系统需要发送向用户发送验证信息
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/5 10:41
 */
@Configuration
public class RabbitMqProducerConfig {

    @Bean("directExchange")
    public Exchange getDirectExchange() {
        return ExchangeBuilder.directExchange(ProducerConstant.EXCHANGE_DIRECT).durable(true).build();
    }

    @Bean("emailQueue")
    public Queue getEmailQueue() {
        return QueueBuilder.durable(CommonConstant.QUEUE_EMAIL).build();
    }

    @Bean("phoneQueue")
    public Queue getPhoneQueue() {
        return QueueBuilder.durable(CommonConstant.QUEUE_PHONE).build();
    }

    @Bean
    public Binding getDirectExchangeEmailQueueBinding(@Qualifier("directExchange") Exchange exchange, @Qualifier("emailQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_EMAIL).noargs();
    }

    @Bean
    public Binding getDirectExchangePhoneQueueBinding(@Qualifier("directExchange") Exchange exchange, @Qualifier("phoneQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_PHONE).noargs();
    }

    @Bean("fanoutExchange")
    public Exchange getFanoutExchange(){
        return ExchangeBuilder.fanoutExchange(ProducerConstant.EXCHANGE_FANOUT).durable(true).build();
    }

    @Bean("shortMessageQueue1")
    public Queue getShortMessageQueue1() {
        return QueueBuilder.durable(CommonConstant.QUEUE_SHORT_MESSAGE_1).build();
    }

    @Bean("shortMessageQueue2")
    public Queue getShortMessageQueue2() {
        return QueueBuilder.durable(CommonConstant.QUEUE_SHORT_MESSAGE_2).build();
    }

    @Bean("shortMessageQueue3")
    public Queue getShortMessageQueue3() {
        return QueueBuilder.durable(CommonConstant.QUEUE_SHORT_MESSAGE_3).build();
    }

    @Bean
    public Binding getFanoutExchangeShortMessageQueueBinding1(@Qualifier("fanoutExchange") Exchange exchange, @Qualifier("shortMessageQueue1") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_PHONE).noargs();
    }

    @Bean
    public Binding getFanoutExchangeShortMessageQueueBinding2(@Qualifier("fanoutExchange") Exchange exchange, @Qualifier("shortMessageQueue2") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_PHONE).noargs();
    }

    @Bean
    public Binding getFanoutExchangeShortMessageQueueBinding3(@Qualifier("fanoutExchange") Exchange exchange, @Qualifier("shortMessageQueue3") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_PHONE).noargs();
    }

    @Bean("topicExchange")
    public Exchange getTopicExchange(){
        return ExchangeBuilder.topicExchange(ProducerConstant.EXCHANGE_TOPIC).durable(true).build();
    }

    @Bean("logQueue")
    public Queue getLogQueue() {
        return QueueBuilder.durable(CommonConstant.QUEUE_LOG).build();
    }

    @Bean("logErrorQueue")
    public Queue getLogErrorQueue() {
        return QueueBuilder.durable(CommonConstant.QUEUE_LOG_ERROR).build();
    }

    @Bean
    public Binding getTopicExchangeLogInfoBinding(@Qualifier("topicExchange") Exchange exchange, @Qualifier("logQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_LOG_ALL).noargs();
    }

    @Bean
    public Binding getTopicExchangeLogErrorBinding(@Qualifier("topicExchange") Exchange exchange, @Qualifier("logErrorQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ProducerConstant.ROUTE_LOG_ERROR).noargs();
    }

}
