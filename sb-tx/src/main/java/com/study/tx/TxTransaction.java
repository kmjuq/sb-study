package com.study.tx;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/9 03:48
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
@Entity
public class TxTransaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

}
