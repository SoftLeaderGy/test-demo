package com.yang.excelpoi.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.yang.excelpoi.easyexcel.dto.DemoData;
import com.yang.excelpoi.easyexcel.dto.DemoReadData;
import org.junit.Test;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/09/20/22:01
 */
public class TestReadEasyExcel {
    public static final String PATH = "/Users/yang/IdeaProjects/SoftLeaderGy/test-demo/test-demo/excel-poi/";

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = PATH + "easyexcel.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoReadData.class, new DemoDataListener()).sheet().doRead();
    }

}
