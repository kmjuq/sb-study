package com.study.jpa.service;

import com.study.jpa.domain.TaskTemplateCol;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020-01-09 01:44
 */
@Service
public interface ITaskTemplateColService {

    /**
     * 通过主键找实体
     */
    TaskTemplateCol findOneByTemplateColId(Long id);

    List<TaskTemplateCol> findAllByTemplateId(Long id);

    TaskTemplateCol save(TaskTemplateCol ttlc);

    void deleteByTemplateColId(Long id);

}
