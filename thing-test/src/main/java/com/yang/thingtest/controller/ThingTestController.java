package com.yang.thingtest.controller;

import com.yang.thingtest.dto.UserDTO;
import com.yang.thingtest.service.ThingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/08/28/15:09
 */
@RestController
public class ThingTestController {

    @Autowired
    private ThingTestService thingTestService;

    @PostMapping("/upName")
    public Integer upName(@RequestBody UserDTO userDTO) {
        return thingTestService.upName(userDTO);
    }
}
