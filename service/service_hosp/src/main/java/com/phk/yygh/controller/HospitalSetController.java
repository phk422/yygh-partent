package com.phk.yygh.controller;

import com.phk.yygh.model.hosp.HospitalSet;
import com.phk.yygh.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/4/11
 **/
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation("获取医院设置列表")
    @GetMapping("/findAll")
    public List<HospitalSet> findAllHostpitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }
}
