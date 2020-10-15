package api.jpa.dto;

import java.util.List;

public interface TaskTemplateService {

    TaskTemplateCol findOneByTemplateColId(Long id);

    List<TaskTemplateCol> findAllByTemplateId(Long id);

    TaskTemplateCol save(TaskTemplateCol ttlc);

    void deleteByTemplateColId(Long id);

    String dubboHello(String name);

}
