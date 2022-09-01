package com.yang.threadtest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.threadtest.dto.IntfCallLogC;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/29/22:30
 */
@Mapper
public interface QueryAllMapper extends BaseMapper<IntfCallLogC>{
}
