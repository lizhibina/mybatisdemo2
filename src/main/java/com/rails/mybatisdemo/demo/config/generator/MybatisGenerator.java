package com.rails.mybatisdemo.demo.config.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.springframework.stereotype.Component;

/**
 * @author
 * @description mybatis-plus 代码生成器配置
 */
@Component(value = "MybatisGenerator")
public class MybatisGenerator extends SuperGenerator {

    /**
     * @param tableNames 表名
     * @param prefix 表前缀
     */
    public void generator(String tableNames,String prefix,String author) {
        String[] names = tableNames.split(",");
        for (String name : names) {
            AutoGenerator mpg = getAutoGenerator(name,prefix,author);
            mpg.execute();
            if (name == null) {
                System.out.println(" Generator Success !");
            } else {
                System.out.println(" TableName【 " + name + " 】" + "Generator Success !");
            }
        }
    }
}
