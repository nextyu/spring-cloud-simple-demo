package com.nextyu.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-05-26 17:38
 *
 * @author nextyu
 */
@Api(value = "订单API", tags = "订单API")
@RefreshScope
@RequestMapping("/orders")
@RestController
public class OrderController {

    /*@Value("${haha}")*/
    public String haha;

    @ApiOperation(value = "获取订单列表", notes = "获取订单列表")
    @RequestMapping(method = RequestMethod.GET)
    public Object list() {

        return "success---" + haha;
    }
}
