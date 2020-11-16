/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.exc.kinfe4j.web.v3;

import com.exc.kinfe4j.vo.Result;
import com.exc.kinfe4j.vo.VideoVO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * @author Huang Min
 * 2020/09/18 11:02
 * @since: 1.0
 */
@Api(tags = "Hello 50所 排序1 类名C")
@ApiSort(1)
@CrossOrigin
@RestController
@RequestMapping("/v3/c")
public class V3HelloControllerC {
    private static final Logger logger = LoggerFactory.getLogger(V3HelloControllerC.class);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户姓名",required = true,dataType = "String",paramType = "path",example = "jack")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "接口返回成功状态"),
            @ApiResponse(code = 500, message = "接口返回未知错误，请联系开发人员调试")
    })
    @ApiOperation(value = "测试 HelloControllerC Get 接口", notes = "访问此接口，返回hello语句，测试接口")
    @GetMapping("hello/{name}")
    public Result hello(@PathVariable String name){
        Result results = new Result(200,"请求参数的用户姓名是:"+name);
        return results;
    }

    @ApiOperationSupport(order=3)
    @ApiOperation(value = "测试3号Post接口")
    @PostMapping(value = "/delete3")
    public Result delete3(@RequestBody VideoVO videoVO) {
        logger.info("接口请求参数:{}", videoVO);
        return new Result(200,videoVO.toString());
    }

    @ApiOperationSupport(order=2)
    @ApiOperation(value = "测试2号Post接口")
    @PostMapping(value = "/delete2")
    public Result delete2(@RequestBody VideoVO videoVO) {
        logger.info("接口请求参数:{}", videoVO);
        return new Result(200,videoVO.toString());
    }

    @ApiOperationSupport(order=1)
    @ApiOperation(value = "测试1号Post接口1")
    @PostMapping(value = "/delete1")
    public Result delete1(@RequestBody VideoVO videoVO) {
        logger.info("接口请求参数:{}", videoVO);
        return new Result(200,videoVO.toString());
    }

}
