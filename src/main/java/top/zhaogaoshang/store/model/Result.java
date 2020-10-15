package top.zhaogaoshang.store.model;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 赵高尚
 * 2020/10/3 0003
 */
@Component
public class Result {
    Integer code; // 1为成功 2为失败
    String message;
    Object data;

    // 成功
    public void success(Object data){
        this.data = data;
        this.code = 1;
        this.message = "成功";
    }

    public void error(String message){
        this.code = 2;
        this.message = message;
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
