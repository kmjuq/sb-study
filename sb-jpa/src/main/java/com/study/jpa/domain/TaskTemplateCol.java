package com.study.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 任务模版列配置
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-08 22:56
 */
@Setter
@Getter
@Accessors(chain = true)
@Entity
@ToString
public class TaskTemplateCol {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long templateColId;

    /**
     * 外键 {@link TaskTemplateDefine} 主键
     */
    @Column(nullable = false)
    private Long templateId;

    /**
     * 序号
     */
    @Column(nullable = false)
    private Long serialNumber;

    /**
     * 列名
     */
    @Column(length = 50,nullable = false)
    private String colName;

    /**
     * 列名称，备注
     */
    @Column(length = 100,nullable = false)
    @ColumnDefault("'desc'")
    private String colDesc;

    /**
     * 格式掩码
     */
    @Column(length = 50,nullable = false)
    private String formatCode;

    /**
     * 是否必输
     * columnDefinition 用来替换定义的数据类型
     */
//    @Column(nullable = false,columnDefinition = "varchar(1) default 'Y' comment '是否必输'")
    @Column(nullable = false,length = 1)
    private String requiredFlag;

    @Version
    private Long versionId;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;

}
