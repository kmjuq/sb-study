package com.study.sbrabbitmq.rabbitmqproducer;

import com.study.sbrabbitmq.rabbitmqproducer.producer.ProducerConstant;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitmqProducerApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void demo1(){
        String email = "{'email':'kemengjian@126.com'}";
        String phone = "{'phone':'17621501943'}";
        rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_DIRECT, ProducerConstant.ROUTE_EMAIL,email);
        rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_DIRECT, ProducerConstant.ROUTE_PHONE,phone);
    }

    @Test
    public void demo2(){
        for (int i = 0; i < 20; i++) {
            String email = String.format("{'email':'kemengjian@%s.com'}", i);
            rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_DIRECT, ProducerConstant.ROUTE_EMAIL,email);
        }
    }
    
    @Test
    public void demo3(){
        String message = "欢迎来到南京市！";
        rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_FANOUT,"",message);
    }

    @Test
    public void demo4(){
        String message = "log messge";
        String errorMsg = "log error message";
        rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_TOPIC,ProducerConstant.ROUTE_LOG_ERROR_HCA,errorMsg);
        rabbitTemplate.convertAndSend(ProducerConstant.EXCHANGE_TOPIC,ProducerConstant.ROUTE_LOG_INFO_HPM,message);
    }

}
