package com.nextyu.vo;

/**
 * created on 2017-06-07 18:42
 *
 * @author nextyu
 */
public class ResponseVO<T> {
    private ResponseHead responseHead;
    private ResponseBody<T> responseBody;

    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public ResponseBody<T> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody<T> responseBody) {
        this.responseBody = responseBody;
    }
}
