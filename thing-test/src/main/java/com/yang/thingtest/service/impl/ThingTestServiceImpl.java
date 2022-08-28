package com.yang.thingtest.service.impl;

import com.yang.thingtest.dao.ThingTestMapper;
import com.yang.thingtest.dto.UserDTO;
import com.yang.thingtest.service.ThingTestService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/28/15:10
 */
@Service("ThingTestServiceImpl")
public class ThingTestServiceImpl implements ThingTestService {

    @Autowired
    private ThingTestMapper thingTestMapper;


    /**
     * 测试@Transactional注解回滚异常
     * @param userDTO
     * @return
     */
    @Override
    @SneakyThrows
//    @Transactional
    @Transactional(rollbackFor = Throwable.class)
    public Integer upName(UserDTO userDTO) {
        thingTestMapper.updateById(userDTO);
        try {
            int a = 1/0;
        }catch (Exception e){
            throw new Throwable();
        }
        return 1;
    }
}
