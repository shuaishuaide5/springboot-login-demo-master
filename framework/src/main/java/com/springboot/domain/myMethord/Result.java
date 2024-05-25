package com.springboot.domain.myMethord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Result<T> {
    private String code;
    private String msg;
    private T data;
    private Integer uid;
    private String sessionId;
    public Result(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public static Result okResult(Object data) {
        Result result = new Result<>();
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }
    public static Result okResult(String msg) {
        Result result = new Result<>();
        if(msg!=null) {
            result.setMsg(msg);
        }
        return result;
    }
    public static Result okResult(String msg,String se) {
        Result result = new Result<>();
        if(msg!=null) {
            result.setMsg(msg);
        }
        if(msg!=null) {
            result.setSessionId(se);
        }
        return result;
    }

    public static Result okResult(String msg,Object data) {
        Result result = new Result<>();
        if(data!=null) {
            result.setData(data);
        }
        if(msg!=null) {
            result.setMsg(msg);
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data,Integer uid) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        result.setUid(uid);
        result.setSessionId("");
        return result;
    }

    public static <T> Result<T> success(T data,String msg) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
