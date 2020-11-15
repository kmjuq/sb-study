package com.study.sbmds.hpm.dao.ds1;

import com.study.sbmds.hpm.entity.ds1.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 15:36
 */
@Repository
public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
