package com.example.consumer;/**
 *
 */

/**
 *
 * @author smq
 * @create 2020-04-21-17:59
 */

public class Data<T> {

    private String name;
    private String value;
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
