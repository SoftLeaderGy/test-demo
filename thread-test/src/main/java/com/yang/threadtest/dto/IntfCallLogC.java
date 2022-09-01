package com.yang.threadtest.dto;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * 接口调用日志(IntfCallLogC)实体类
 *
 * @author makejava
 * @since 2022-08-21 16:20:34
 */
@TableName("intf_call_log_c")
public class IntfCallLogC implements Serializable {
    private static final long serialVersionUID = -18950522641039613L;
    /**
     * 调用日志ID
     */
    private String callLogId;
    /**
     * 操作日志ID
     */
    private String oprtLogId;
    /**
     * 操作人员ID
     */
    private String oprtPsnId;
    /**
     * 接口返回报文
     */
    private String intfRetnMsg;
    /**
     * 接口参数
     */
    private String intfPara;
    /**
     * 接口方法
     */
    private String intfMtd;
    /**
     * 接口方法路径
     */
    private String intfMtdUrl;
    /**
     * 第三方接口路径
     */
    private String ttpIntfUrl;
    /**
     * 接口调用时间
     */
    private Date intfCallTime;
    /**
     * 接口调用成功标志
     */
    private String intfCallSuccFlag;
    /**
     * 接口错误日志消息
     */
    private String intfErrLogMsg;
    /**
     * 数据唯一记录号
     */
    private String rid;
    /**
     * 数据创建时间
     */
    private Date crteTime;
    /**
     * 数据更新时间
     */
    private Date updtTime;
    /**
     * 经办渠道
     */
    private String optChnl;
    /**
     * 接口调用名称
     */
    private String intfCallName;
    /**
     * 接口调用系统名称
     */
    private String intfCallSysName;


    public String getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(String callLogId) {
        this.callLogId = callLogId;
    }

    public String getOprtLogId() {
        return oprtLogId;
    }

    public void setOprtLogId(String oprtLogId) {
        this.oprtLogId = oprtLogId;
    }

    public String getOprtPsnId() {
        return oprtPsnId;
    }

    public void setOprtPsnId(String oprtPsnId) {
        this.oprtPsnId = oprtPsnId;
    }

    public String getIntfRetnMsg() {
        return intfRetnMsg;
    }

    public void setIntfRetnMsg(String intfRetnMsg) {
        this.intfRetnMsg = intfRetnMsg;
    }

    public String getIntfPara() {
        return intfPara;
    }

    public void setIntfPara(String intfPara) {
        this.intfPara = intfPara;
    }

    public String getIntfMtd() {
        return intfMtd;
    }

    public void setIntfMtd(String intfMtd) {
        this.intfMtd = intfMtd;
    }

    public String getIntfMtdUrl() {
        return intfMtdUrl;
    }

    public void setIntfMtdUrl(String intfMtdUrl) {
        this.intfMtdUrl = intfMtdUrl;
    }

    public String getTtpIntfUrl() {
        return ttpIntfUrl;
    }

    public void setTtpIntfUrl(String ttpIntfUrl) {
        this.ttpIntfUrl = ttpIntfUrl;
    }

    public Date getIntfCallTime() {
        return intfCallTime;
    }

    public void setIntfCallTime(Date intfCallTime) {
        this.intfCallTime = intfCallTime;
    }

    public String getIntfCallSuccFlag() {
        return intfCallSuccFlag;
    }

    public void setIntfCallSuccFlag(String intfCallSuccFlag) {
        this.intfCallSuccFlag = intfCallSuccFlag;
    }

    public String getIntfErrLogMsg() {
        return intfErrLogMsg;
    }

    public void setIntfErrLogMsg(String intfErrLogMsg) {
        this.intfErrLogMsg = intfErrLogMsg;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Date getCrteTime() {
        return crteTime;
    }

    public void setCrteTime(Date crteTime) {
        this.crteTime = crteTime;
    }

    public Date getUpdtTime() {
        return updtTime;
    }

    public void setUpdtTime(Date updtTime) {
        this.updtTime = updtTime;
    }

    public String getOptChnl() {
        return optChnl;
    }

    public void setOptChnl(String optChnl) {
        this.optChnl = optChnl;
    }

    public String getIntfCallName() {
        return intfCallName;
    }

    public void setIntfCallName(String intfCallName) {
        this.intfCallName = intfCallName;
    }

    public String getIntfCallSysName() {
        return intfCallSysName;
    }

    public void setIntfCallSysName(String intfCallSysName) {
        this.intfCallSysName = intfCallSysName;
    }

}

