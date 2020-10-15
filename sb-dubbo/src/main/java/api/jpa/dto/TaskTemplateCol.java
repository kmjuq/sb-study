package api.jpa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@ToString
public class TaskTemplateCol implements Serializable {

    /**
     * 主键
     */
    private Long templateColId;

    private Long templateId;

    /**
     * 序号
     */
    private Long serialNumber;

    /**
     * 列名
     */
    private String colName;

    /**
     * 列名称，备注
     */
    private String colDesc;

    /**
     * 格式掩码
     */
    private String formatCode;

    /**
     * 是否必输
     */
    private String requiredFlag;

    private Long versionId;

    private Date creationDate;

    private Date updateDate;

}
