package com.example.consumer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/**
 *
 * @author smq
 * @create 2020-04-21-17:43
 */

public class Result<T> {

    private String msg;
    private Integer ret;
    private List<T> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    private static <T> Result<Data<T>> parseListResult(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, buildType(Result.class, Data.class, clazz));
    }

    private static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types != null && types.length > 0) {
            for (int i = types.length - 1; i > 0; i--) {
                beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
            }
        }
        return beforeType;
    }

    public static void main(String[] args) {
        String res = "{\"data\":[{\"name\":\"hh\",\"t\":1,\"value\":\"value\"}],\"msg\":\"msg\",\"ret\":0}";
        Result<Data<Integer>> result = parseListResult(res, Integer.class);
        System.out.println(JSONObject.toJSONString(result));

        // Result<Data<Integer>> result = new Result<>();
        // Data<Integer> data = new Data<>();
        // data.setT(1);
        // data.setName("hh");
        // data.setValue("value");
        // result.setMsg("msg");
        // result.setRet(0);
        // result.setData(Arrays.asList(data));
        // System.out.println(JSONObject.toJSONString(result));

    }
}


