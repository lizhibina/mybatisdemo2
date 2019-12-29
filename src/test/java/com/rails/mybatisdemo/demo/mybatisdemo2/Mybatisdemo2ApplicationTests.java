package com.rails.mybatisdemo.demo.mybatisdemo2;

import com.rails.mybatisdemo.demo.base.From.CreateOrderForm;
import com.rails.mybatisdemo.demo.config.generator.MybatisGenerator;
import com.rails.mybatisdemo.demo.model.entity.SljyOrderProduct;
import com.rails.mybatisdemo.demo.service.SljyOrderProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mybatisdemo2ApplicationTests {

    @Autowired
    MybatisGenerator mybatisGenerator;


    @Autowired
    SljyOrderProductService sljyOrderProductService;

    @Test
    public void contextLoads() {
    }

    /**
     * 生成实体
     */
    @Test
    public void generator() {
        mybatisGenerator.generator("sljy_order_product","","lizhibin");
    }
    @Test
    public void testDevTools() {
        System.out.println("sssssss");
        CreateOrderForm sljyOrderProduct = new CreateOrderForm();
        sljyOrderProductService.saveOrderProduct(sljyOrderProduct);
    }
}
