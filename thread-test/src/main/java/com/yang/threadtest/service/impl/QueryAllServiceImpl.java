package com.yang.threadtest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.threadtest.dao.QueryAllMapper;
import com.yang.threadtest.dto.IntfCallLogC;
import com.yang.threadtest.dto.QueryAllInDTO;
import com.yang.threadtest.service.QueryAllService;
import com.yang.threadtest.service.QueryTaskService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/29/22:30
 */
@Service("QueryAllServiceImpl")
@Slf4j
public class QueryAllServiceImpl implements QueryAllService {

    @Autowired
    private QueryAllMapper queryAllMapper;

    @Autowired
    private QueryTaskService queryTaskService;

    @Value("${task.executor.expiration.time}")
    private Integer expirationTime;
    @Override
    public List<IntfCallLogC> queryAllList(QueryAllInDTO queryAllInDTO) {
        Page<IntfCallLogC> intfCallLogCPage = new Page<>();
        intfCallLogCPage.setCurrent(queryAllInDTO.getPageNo());
        intfCallLogCPage.setSize(queryAllInDTO.getPageSize());
        IPage<IntfCallLogC> intfCallLogCIPage = queryAllMapper.selectPage(intfCallLogCPage, null);
        return intfCallLogCIPage.getRecords();
    }

//    @Override
//    @SneakyThrows
//    public List<IntfCallLogC> queryAllListAsync(QueryAllInDTO queryAllInDTO) {
//        long l = System.currentTimeMillis();
//        List<Future<List<IntfCallLogC>>> futures = new ArrayList<>();
//        List<IntfCallLogC> intfCallLogCS = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Long aLong = new Long(i);
//            queryAllInDTO.setPageNo(aLong);
//            queryAllInDTO.setPageSize(1000L);
//            while (3 <= futures.size()) {
//                for (Future<List<IntfCallLogC>> future : futures) {
//                    if(future.isDone()){
//                        intfCallLogCS.addAll(future.get());
//                        intfCallLogCS.remove(future);
//                        break;
//                    }
//                }
//            }
//            Future<List<IntfCallLogC>> listFuture = queryTaskService.queryAllListForAsync(queryAllInDTO);
//            futures.add(listFuture);
//        }
//        int count = 0;
//        while (count != futures.size()) {
//            boolean[] booleans = new boolean[futures.size()];
//            for (int i = 0; i < futures.size(); i++) {
//                if(!booleans[i] && futures.get(i).isDone()){
//                    intfCallLogCS.addAll(futures.get(i).get());
//                }
//            }
//        }
//        log.info("返回的数据条数 =====> {}",intfCallLogCS.size());
//        log.info("多线程使用时间 ====》 {}",(System.currentTimeMillis()-l)/1000);
//        return intfCallLogCS;
//    }

    @Override
    @SneakyThrows
    public List<IntfCallLogC> queryAllListAsync(QueryAllInDTO queryAllInDTO) {
        long startTime = System.currentTimeMillis();
        List<Future<List<IntfCallLogC>>> futures = new ArrayList<>();
        List<IntfCallLogC> intfCallLogCS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Long aLong = new Long(i);
            queryAllInDTO.setPageNo(aLong);
            QueryAllInDTO queryAllInDTO1 = new QueryAllInDTO();
            queryAllInDTO1.setPageNo(aLong);
            queryAllInDTO1.setPageSize(queryAllInDTO.getPageSize());
            while (3 <= futures.size()) {
                for (Future<List<IntfCallLogC>> future : futures) {
                    if(future.isDone()){
                        intfCallLogCS.addAll(future.get());
                        futures.remove(future);
                        break;
                    }
                }
            }
            Future<List<IntfCallLogC>> listFuture = queryTaskService.queryAllListForAsync(queryAllInDTO1);
            futures.add(listFuture);
        }
        int count = 0;
        while (count != futures.size()) {
            boolean[] booleans = new boolean[futures.size()];
            for (int i = 0; i < futures.size(); i++) {
                if(!booleans[i] && futures.get(i).isDone()){
                    intfCallLogCS.addAll(futures.get(i).get());
                    ++count;
                    booleans[i] = true;
                }
            }
            if((System.currentTimeMillis() - startTime) / 1000 > expirationTime){
                throw new RuntimeException("查询超时！");
            }
        }
        log.info("返回的数据条数 =====> {}",intfCallLogCS.size());
        log.info("多线程使用时间 ====》 {}",(System.currentTimeMillis()-startTime)/1000);
        return intfCallLogCS;
    }
}
