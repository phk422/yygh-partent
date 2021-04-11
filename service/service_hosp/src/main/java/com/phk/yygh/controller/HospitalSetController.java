package com.phk.yygh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phk.yygh.common.exception.YyghException;
import com.phk.yygh.common.result.Result;
import com.phk.yygh.model.hosp.HospitalSet;
import com.phk.yygh.service.HospitalSetService;
import com.phk.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public Result findAllHostpitalSet() {
        try {
            int a = 1/0;
        } catch (Exception e) {
            throw new YyghException("算式错误", 201);
        }
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }


    // 分页查询医院设置列表
    @ApiOperation("分页查询医院设置列表")
    @PostMapping("/findPageHostSet/{currentPage}/{size}")
    public Result findPageHostSet(@PathVariable @ApiParam("当前页码") long currentPage,
                                  @PathVariable @ApiParam("当前页显示条数") long size,
                                  @RequestBody(required = false) @ApiParam("查询条件") HospitalSetQueryVo hospitalSetQueryVo) {

        System.out.println(currentPage);
        // 分页查询
        Page<HospitalSet> page = new Page<>(currentPage, size);
        // 获取分页查询条件
        String hosname = hospitalSetQueryVo.getHosname();
        String hoscode = hospitalSetQueryVo.getHoscode();
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(hoscode)) {
            wrapper.eq("hoscode", hoscode);
        }
        if (!StringUtils.isEmpty(hosname)) {
            wrapper.like("hosname", hosname);
        }
        Page<HospitalSet> hospitalSetPage = hospitalSetService.page(page, wrapper);
        return Result.ok(hospitalSetPage);

    }
}
