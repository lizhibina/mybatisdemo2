package com.rails.mybatisdemo.demo.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rails.mybatisdemo.demo.base.From.CreateOrderForm;
import com.rails.mybatisdemo.demo.model.entity.SljyOrderProduct;
import com.rails.mybatisdemo.demo.service.SljyOrderProductService;
import com.rails.mybatisdemo.demo.utils.CommonUtils;
import com.rails.mybatisdemo.demo.utils.PaginationList;
import com.rails.mybatisdemo.demo.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author lizhibin
 * @since 2019-04-19
 */
@Api(tags = {"demo接口测试"})
@RestController
@RequestMapping("/order")
public class SljyOrderProductApi {
    //demo接口测试
    @Autowired
    SljyOrderProductService resultService;

    @ApiOperation(value = "根据用户名查询订单列表信息")
    @PostMapping("/queryOrderList")
    public ResultData<PaginationList> queryList(String userName,  String pageNum, String pageSize) {
        QueryWrapper<SljyOrderProduct> ew = new QueryWrapper<>();
        if(!StringUtils.isEmpty(userName)){
            ew.eq("user_name", userName);
        }
        IPage<SljyOrderProduct> result = resultService.page(new Page<>(Integer.parseInt(pageNum), Integer.parseInt(pageSize)), ew);
        return ResultData.success(new PaginationList(result.getTotal(), result.getRecords()));
    }
    @ApiOperation(value = "springBoot热加载测试")
    @PostMapping("/devTools")
    public ResultData<?> devTools(String abcd) {
//        QueryWrapper<SljyOrderProduct> ew = new QueryWrapper<>();
//        if(!StringUtils.isEmpty(abcd)){
//            ew.eq("user_name", userName);
//        }
        String SS_S="sss";
//        IPage<SljyOrderProduct> result = resultService.page(new Page<>(Integer.parseInt(pageNum), Integer.parseInt(pageSize)), ew);
        String s = CommonUtils.springBootDevTest(abcd);
        return ResultData.success(s);
    }

    public static void main(String[] args) {
        CreateOrderForm createOrderForm = new CreateOrderForm().setBoardTrainCode("").setCoachNo("");
    }




}

