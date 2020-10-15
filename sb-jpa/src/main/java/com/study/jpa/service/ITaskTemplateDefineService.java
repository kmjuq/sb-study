package com.study.jpa.service;

import com.study.jpa.domain.TaskTemplateDefine;
import org.springframework.stereotype.Service;

@Service
public interface ITaskTemplateDefineService {

    TaskTemplateDefine findById(Long id);

}
