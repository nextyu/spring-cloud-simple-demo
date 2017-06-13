package com.nextyu.web.controller;

import com.nextyu.entity.User;
import com.nextyu.service.RibbonHystrixService;
import com.nextyu.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * created on 2017-06-12 17:00
 *
 * @author nextyu
 */
@RestController
public class RibbonHystrixController {
    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbonHystrix/{id}")
    public User getById(@PathVariable Long id) {
        return ribbonHystrixService.getById(id);
    }
}
