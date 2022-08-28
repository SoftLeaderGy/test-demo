package com.yang.thingtest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.thingtest.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/28/15:11
 */
@Mapper
public interface ThingTestMapper extends BaseMapper<UserDTO> {
}
