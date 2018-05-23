package com.exam.api.utils;

import java.io.Serializable;
import java.util.Collections;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 11:31 2018/5/22
 */
public class Result<T> implements Serializable {

    public static final Result<Object> SUCCESS = new Result<Object>(true);
    public static final Result<Object> FAIL = new Result<Object>(false);

    private int code;

    private String msg;

    private boolean status;

    private T data;

    public Result() {

    }


    public Result(boolean status) {
        if (status = true) {
            this.status = status;
            this.msg = "success";
            this.code = 0;
            this.data = (T) Collections.emptyMap();
        } else {
            this.status = status;
            this.msg = "请求失败";
            this.code = 1;
            this.data = (T) Collections.emptyMap();
        }
    }

    /**
     * 如果放入的数据不为空, this.status = true;this.msg = "success";this.code = "0000"; 创建一个新的实例 Result.
     *
     * @param data
     */
    public Result(T data) {
        this.status = true;
        this.data = data;
        this.msg = "success";
        this.code = 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
