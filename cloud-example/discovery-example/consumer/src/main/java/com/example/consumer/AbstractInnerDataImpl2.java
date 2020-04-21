package com.example.consumer;

/**
 * @author smq
 */

public class AbstractInnerDataImpl2<T> extends AbstractInnerData {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
