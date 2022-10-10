package com.yang.threadtest.service;

import com.yang.threadtest.dto.IntfCallLogC;
import com.yang.threadtest.dto.QueryAllInDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/29/22:29
 */
@Service
public interface QueryAllService {

    List<IntfCallLogC> queryAllList(QueryAllInDTO queryAllInDTO);
    List<IntfCallLogC> queryAllListAsync(QueryAllInDTO queryAllInDTO);

    String queryAllListAsyncTestThrows(QueryAllInDTO queryAllInDTO);


}
