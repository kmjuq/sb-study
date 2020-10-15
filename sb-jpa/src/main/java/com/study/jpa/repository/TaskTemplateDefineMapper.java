package com.study.jpa.repository;

import com.study.jpa.domain.TaskTemplateDefine;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**å
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/9/7 18:43
 */
@Mapper
public interface TaskTemplateDefineMapper {

    TaskTemplateDefine findById(Long id);

}
