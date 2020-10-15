package api.jpa;

import api.jpa.dto.TaskTemplateCol;

public interface TaskTemplateService {

    TaskTemplateCol findOneByTemplateColId(Long id);

    List<TaskTemplateCol> findAllByTemplateId(Long id);

    TaskTemplateCol save(TaskTemplateCol ttlc);

    void deleteByTemplateColId(Long id);

}
