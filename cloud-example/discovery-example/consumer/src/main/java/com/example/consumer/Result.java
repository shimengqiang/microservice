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

    private static <T extends AbstractInnerData> Result<Data<T>> parseListResult(String json, Type... types) {
        return JSONObject.parseObject(json, buildType(types));
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
        Result<Data<AbstractInnerDataImpl>> result = new Result<>();
        Data<AbstractInnerDataImpl> data = new Data<>();
        AbstractInnerDataImplImpl data1 = new AbstractInnerDataImplImpl();
        data1.setName("name");
        data1.setValue("value");
        data1.setString("sssss");
        data.setT(data1);
        result.setMsg("msg");
        result.setRet(0);
        result.setData(Arrays.asList(data));
        String string = JSONObject.toJSONString(result);
        System.out.println(string);
        Result<Data<AbstractInnerDataImplImpl>> dataResult = parseListResult
            (string, Result.class, Data.class, AbstractInnerDataImplImpl.class);
        System.out.println(JSONObject.toJSONString(dataResult));

        // Result<Data> result = new Result<>();
        // Data<AbstractInnerData> data = new Data<>();
        // AbstractInnerDataImpl2<Impl2> data1 = new AbstractInnerDataImpl2<>();
        // Impl2 impl2 = new Impl2();
        // impl2.setString("impl2");
        // data1.setT(impl2);
        // data.setT(data1);
        // result.setMsg("msg");
        // result.setRet(0);
        // result.setData(Arrays.asList(data));
        // String string = JSONObject.toJSONString(result);
        // System.out.println(string);
        //
        // Result<Data<AbstractInnerDataImpl2<Impl2>>> dataResult = JSONObject.parseObject(string, buildType(Result.class, Data.class, AbstractInnerDataImpl2.class
        // ,Impl2.class));
        // System.out.println(JSONObject.toJSONString(dataResult));


    }
}


