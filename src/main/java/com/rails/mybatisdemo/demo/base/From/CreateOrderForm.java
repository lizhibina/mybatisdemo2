/**
 * Copyright 2017 电子计算技术研究所
 * All Right Reserved
 * Author: wangbin
 * Create Date: 2017-5-25
 */
package com.rails.mybatisdemo.demo.base.From;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.Filter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Accessors(chain = true)
//@Setter
//@Getter
@Data
public class CreateOrderForm {

       @NotBlank
       @javax.validation.constraints.NotBlank
       /*销售渠道*/
       private String salesChannels;


       @NotBlank
       /**
        * 用户名
        */
       private String userName;
}
