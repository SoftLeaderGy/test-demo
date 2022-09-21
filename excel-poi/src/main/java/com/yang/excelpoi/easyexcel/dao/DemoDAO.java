package com.yang.excelpoi.easyexcel.dao;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/09/20/22:05
 */

import com.yang.excelpoi.easyexcel.dto.DemoData;
import com.yang.excelpoi.easyexcel.dto.DemoReadData;

import java.util.List;

/**
 * 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 **/
public class DemoDAO {
    public void save(List<DemoReadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
