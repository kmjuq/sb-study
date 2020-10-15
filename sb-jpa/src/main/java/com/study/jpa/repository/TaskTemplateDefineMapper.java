package com.study.jpa.repository;

import com.study.jpa.domain.TaskTemplateCol;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/9/7 18:43
 */
@Mapper
public interface TaskTemplateDefineMapper {

    Optional<TaskTemplateCol> findByTemplateColId(Long id);

}
