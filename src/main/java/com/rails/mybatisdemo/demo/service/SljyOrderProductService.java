package com.rails.mybatisdemo.demo.service;

import com.rails.mybatisdemo.demo.base.From.CreateOrderForm;
import com.rails.mybatisdemo.demo.model.entity.SljyOrderProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author lizhibin
 * @since 2019-04-19
 */
public interface SljyOrderProductService extends IService<SljyOrderProduct> {

    /**
    * Description 
    * 
    * @author Lizhibin 
    * @description 保存订单
    * @param createOrderForm
    * @return void
    * @createDate 2019/8/3/14:27
    **/
    void saveOrderProduct(CreateOrderForm createOrderForm);

}
