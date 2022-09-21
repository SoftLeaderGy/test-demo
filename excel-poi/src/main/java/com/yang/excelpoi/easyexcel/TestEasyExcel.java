package com.yang.excelpoi.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.yang.excelpoi.easyexcel.dto.DemoData;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/09/20/21:29
 */
public class TestEasyExcel {

    public static final String PATH = "/Users/yang/IdeaProjects/SoftLeaderGy/test-demo/test-demo/excel-poi/";
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void simpleWrite() {
        // 写法1
        String fileName =PATH + "easyexcel.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        // write(文件路径，格式类)
        // sheet(工作表名)
        // doWrite(数据)
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }
}
