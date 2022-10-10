package com.yang.threadtest.service;

import com.yang.threadtest.dto.IntfCallLogC;
import com.yang.threadtest.dto.QueryAllInDTO;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/30/16:47
 */
public interface QueryTaskService {
    /**
     * 异步分页查询任务
     * @param queryAllInDTO
     * @return
     */
    Future<List<IntfCallLogC>> queryAllListForAsync(QueryAllInDTO queryAllInDTO);


    Future<Boolean> queryAllListForAsyncTestThrows();
}
