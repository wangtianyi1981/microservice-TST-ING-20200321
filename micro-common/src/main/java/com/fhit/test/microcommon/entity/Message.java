package com.fhit.test.microcommon.entity;

/**
 * @author wty
 * @create 2020-04-14 9:52
 */
public class Message {
    /**
     * 成功或失败
     */
    private boolean flag;

    /**
     * 响应码 200 404 500
     */
    private Integer code;

    /**
     * 请求的结果数据
     */
    private Object data;

    public Message() {
    }

    public Message(boolean flag, Integer code, Object data) {
        this.flag = flag;
        this.code = code;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
