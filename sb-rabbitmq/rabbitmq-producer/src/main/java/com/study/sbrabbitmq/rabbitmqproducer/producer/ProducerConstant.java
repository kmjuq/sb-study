package com.study.sbrabbitmq.rabbitmqproducer.producer;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/5 12:56
 */
public class ProducerConstant {

    // 生产者定义
    public static final String EXCHANGE_DIRECT = "EXCHANGE_DIRECT";
    public static final String EXCHANGE_FANOUT = "EXCHANGE_FANOUT";
    public static final String EXCHANGE_TOPIC = "EXCHANGE_TOPIC";
    // 生产者定义
    public static final String ROUTE_EMAIL = "EMAIL";
    public static final String ROUTE_PHONE = "PHONE";
    public static final String ROUTE_LOG_ALL = "#.LOG.#";
    public static final String ROUTE_LOG_ERROR = "#.LOG.ERROR.#";
    public static final String ROUTE_LOG_INFO_HPM = "HPM.LOG.INFO";
    public static final String ROUTE_LOG_ERROR_HCA = "HCA.LOG.ERROR";
}
