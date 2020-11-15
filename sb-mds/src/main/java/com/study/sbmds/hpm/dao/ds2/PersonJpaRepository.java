package com.study.sbmds.hpm.dao.ds2;

import com.study.sbmds.hpm.entity.ds2.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 15:43
 */
@Repository
public interface PersonJpaRepository extends JpaRepository<Person,Long> {
}
