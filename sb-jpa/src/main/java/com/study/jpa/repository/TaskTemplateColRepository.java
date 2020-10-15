package com.study.jpa.repository;

import com.study.jpa.domain.TaskTemplateCol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskTemplateColRepository extends JpaRepository<TaskTemplateCol,Long> {

    Optional<TaskTemplateCol> findByTemplateColId(Long id);

    Optional<List<TaskTemplateCol>> findByTemplateId(Long id);

    void deleteByTemplateColId(Long id);

}
