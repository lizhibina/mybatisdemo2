package com.rails.mybatisdemo.demo.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.PostgreKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author
 * @date 2019/3/28 14:03
 * @description
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.rails.mybatisdemo.demo.mapper*")
public class MybatisPlusConfig {
    /**
     * mybatis-plus SQL执行效率插件【测试环境开启】
     */
    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 注入主键生成器
     */
    @Bean
    public IKeyGenerator keyGenerator() {
        return new PostgreKeyGenerator();
    }

}
