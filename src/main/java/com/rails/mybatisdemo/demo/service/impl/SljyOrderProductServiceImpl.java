package com.rails.mybatisdemo.demo.service.impl;

import com.rails.mybatisdemo.demo.base.From.CreateOrderForm;
import com.rails.mybatisdemo.demo.model.entity.SljyOrderProduct;
import com.rails.mybatisdemo.demo.mapper.SljyOrderProductMapper;
import com.rails.mybatisdemo.demo.service.SljyOrderProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author lizhibin
 * @since 2019-04-19
 */
@Service
public class SljyOrderProductServiceImpl extends ServiceImpl<SljyOrderProductMapper, SljyOrderProduct> implements SljyOrderProductService {

    @Override
    public void saveOrderProduct(CreateOrderForm createOrderForm) {
    }
}
