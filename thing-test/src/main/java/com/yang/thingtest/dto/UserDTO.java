package com.yang.thingtest.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/28/15:21
 */
@Data
@TableName("thing_test")
public class UserDTO {
    @TableId
    private String id;
    private String name;
}
