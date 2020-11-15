package com.study.tx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/11/9 03:54
 */
@Repository
public interface TxJapRepository extends JpaRepository<TxTransaction,Long> {
}
