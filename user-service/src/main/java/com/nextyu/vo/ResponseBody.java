package com.nextyu.vo;

import java.util.List;

/**
 * created on 2017-06-07 18:43
 *
 * @author nextyu
 */
public class ResponseBody<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
