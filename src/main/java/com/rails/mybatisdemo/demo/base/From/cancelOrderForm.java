package com.rails.mybatisdemo.demo.base.From;/**
 * @Auther: lizhibin
 * @Date: 2020/1/2 16:50
 * @Description:
 */

import lombok.Data;

/**
 * @program: mybatisdemo2
 *
 * @description: 取消订单实体
 *
 * @author: Lizhibin
 *
 * @create: 2020/01/02 16:50
 **/
@Data
public class cancelOrderForm {
    private String orderId;
    private String orderCode;

}


