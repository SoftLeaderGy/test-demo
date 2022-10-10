package com.yang.threadtest.controller;

import com.yang.threadtest.dao.QueryAllMapper;
import com.yang.threadtest.dto.IntfCallLogC;
import com.yang.threadtest.dto.QueryAllInDTO;
import com.yang.threadtest.service.QueryAllService;
import com.yang.threadtest.service.QueryTaskService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/29/22:26
 */
@RestController
@Slf4j
public class QueryAllController {


    @Autowired
    QueryAllService queryAllService;
    @Autowired
    QueryTaskService queryTaskService;

    @Autowired
    QueryAllMapper queryAllMapper;

    /**
     * 单线程进行查询
     * @param queryAllInDTO
     * @return
     */
    @RequestMapping("/queryAllList")
    public List<IntfCallLogC> queryAllList(@RequestBody QueryAllInDTO queryAllInDTO){
        long l = System.currentTimeMillis();
        List<IntfCallLogC> intfCallLogCS = queryAllService.queryAllList(queryAllInDTO);
        log.info("单线程使用时间 ====》 {}",(System.currentTimeMillis()-l)/1000);
        return intfCallLogCS;
    }

    /**
     * 异步进行查询
     * @param queryAllInDTO
     * @return
     */
    @RequestMapping("/queryAllListForAsnyc")
    @SneakyThrows
    public List<IntfCallLogC> queryAllListForAsnyc(@RequestBody QueryAllInDTO queryAllInDTO){
        return queryAllService.queryAllListAsync(queryAllInDTO);
    }

    @RequestMapping("/queryAllListAsyncTestThrows")
    @SneakyThrows
    public String queryAllListAsyncTestThrows(@RequestBody QueryAllInDTO queryAllInDTO){
        return queryAllService.queryAllListAsyncTestThrows(queryAllInDTO);
    }
}
