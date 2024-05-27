package com.demo.cloud.mapper;

import com.demo.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: ${PROJECT_NAME}
 * @description: ${description}
 * @author: David
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/
public interface AccountMapper extends Mapper<Account> {

    /**
     * @param userId
     * @param money  本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}

