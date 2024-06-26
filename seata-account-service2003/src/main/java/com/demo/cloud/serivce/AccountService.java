package com.demo.cloud.serivce;

import org.apache.ibatis.annotations.Param;

/**
 * @program: ${PROJECT_NAME}
 * @description: ${description}
 * @author: David
 * @create: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 **/
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
