package com.yang.threadtest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.threadtest.dao.QueryAllMapper;
import com.yang.threadtest.dto.IntfCallLogC;
import com.yang.threadtest.dto.QueryAllInDTO;
import com.yang.threadtest.service.QueryTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/30/16:47
 */
@Service("QueryTaskServiceImpl")
@Slf4j
public class QueryTaskServiceImpl implements QueryTaskService {

    @Autowired
    QueryAllMapper queryAllMapper;

    /**
     * 异步分页查询任务
     * @param queryAllInDTO
     * @return
     */
    @Override
    @Async("taskQueryExecutor")
    public Future<List<IntfCallLogC>> queryAllListForAsync(QueryAllInDTO queryAllInDTO) {
        Page<IntfCallLogC> intfCallLogCPage = new Page<>();
        intfCallLogCPage.setCurrent(queryAllInDTO.getPageNo());
        intfCallLogCPage.setSize(queryAllInDTO.getPageSize());
        log.info("页数 {}",queryAllInDTO.getPageNo());
        IPage<IntfCallLogC> intfCallLogCIPage = queryAllMapper.selectPage(intfCallLogCPage, null);
        return new AsyncResult<>(intfCallLogCIPage.getRecords());
    }
}
