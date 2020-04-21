package com.example.consumer;/**
 *
 */

/**
 *
 * @author smq
 * @create 2020-04-21-17:59
 */

public class Data<T extends AbstractInnerData> {

   private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
