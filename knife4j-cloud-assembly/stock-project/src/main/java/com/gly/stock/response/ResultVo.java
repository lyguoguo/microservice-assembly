package com.gly.stock.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(Include.NON_NULL)
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = 6543751866024162628L;
    private boolean           result;
    private String            kind;
    private String            msg;
    private T            data;
    private String            nowTime          = formateDate(new Date()); //当前时间

    public ResultVo() {
        this.result = true;
    }

    public ResultVo(T data) {
        this.result = true;
        this.data = data;
    }

    public ResultVo(String kind, String msg) {
        this.result = false;
        this.kind = kind;
        this.msg = msg;
    }

    public ResultVo(boolean result, String kind, String msg) {
        this.result = result;
        this.kind = kind;
        this.msg = msg;
    }

    public static final ResultVo create() {
        return new ResultVo();
    }

    public static final ResultVo create(String kind, String msg) {
        return new ResultVo(kind, msg);
    }

    public static final ResultVo create(boolean result, String kind, String msg) {
        return new ResultVo(result, kind, msg);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public ResultVo(boolean result, T data, String kind, String msg) {
        this.result = result;
        this.data = data;
        this.kind = kind;
        this.msg = msg;
    }


    public final static String     FORMAT_DATE_TIME      = "yyyy-MM-dd HH:mm:ss";

    /** 根据格式格式化日期为字串 **/
    public static String formateDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME);
        try {
            return sdf.format(date);
        } catch (Exception e) {
//            log.error("formateDate error: " + e);
            return null;
        }
    }

}
