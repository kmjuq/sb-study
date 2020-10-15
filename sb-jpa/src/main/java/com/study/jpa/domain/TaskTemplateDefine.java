package com.study.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 * 任务模版定义
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-08 22:56
 */
@Entity
@Setter
@Getter
@Accessors
public class TaskTemplateDefine {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long templateId;

    /**
     * 模版编码
     */
    private String templateCode;

    /**
     * 模版名称
     */
    private String templateName;

    /**
     * 是否启用
     */
    private String enabledFlag;

    /**
     * 是否锁定
     */
    private String lockFlag;

    /**
     * 模版类型
     */
    private String templateType;

}
