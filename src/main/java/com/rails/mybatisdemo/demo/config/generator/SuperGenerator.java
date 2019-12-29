package com.rails.mybatisdemo.demo.config.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

/**
 * @author
 * @description mybatis-plus 代码生成器配置
 */
@Component(value = "SuperGenerator")
public class SuperGenerator {
    /**
     * 获取TemplateConfig
     */
    private TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null);
    }

    /**
     * 获取InjectionConfig
     */
    private InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig() {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getResourcePath() + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
    }

    /**
     * 获取PackageConfig
     */
    private PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent("com.rails.mybatisdemo.demo")
                .setController("api")
                .setEntity("model.entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl");
    }

    /**
     * 获取StrategyConfig
     */
    private StrategyConfig getStrategyConfig(String tableName, String prefix) {
        List<TableFill> tableFillList = getTableFills();
        return new StrategyConfig()
                .setCapitalMode(false)
                .setTablePrefix(prefix)
                .setNaming(NamingStrategy.underline_to_camel)
                .setRestControllerStyle(true)
                .setInclude(tableName);
    }

    /**
     * 获取TableFill策略
     */
    private List<TableFill> getTableFills() {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("createDate", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("createUid", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateUid", FieldFill.INSERT_UPDATE));
        return tableFillList;
    }

    /**
     * 获取DataSourceConfig
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(DbType.POSTGRE_SQL)
                .setTypeConvert(new PostgreSqlTypeConvert())
                .setDriverName("org.postgresql.Driver")
                .setUsername("postgre")
                .setPassword("postgre")
                .setUrl("jdbc:postgresql://198.218.35.24:5433/catering2?characterEncoding=utf8&prepareThreshold=0&flyingBouncer=true");
    }

    /**
     * 获取GlobalConfig
     */
    private GlobalConfig getGlobalConfig(String author) {
        return new GlobalConfig().setDateType(DateType.ONLY_DATE)
                .setOutputDir(getJavaPath())
                .setFileOverride(true)
                .setActiveRecord(false)
                .setEnableCache(false)
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(false)
                .setKotlin(false)
                .setOpen(false)
                .setAuthor(author)
                .setEntityName("%s")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sApi");
    }
    /**
     * 获取根目录
     */
    private String getRootPath() {
        String file = Objects.requireNonNull(SuperGenerator.class.getClassLoader().getResource("")).getFile();
        return new File(file).getParentFile().getParent();
    }

    /**
     * 获取JAVA目录
     */
    private String getJavaPath() {
        return getRootPath() + "/src/main/java";
    }

    /**
     * 获取Resource目录
     */
    private String getResourcePath() {
        return getRootPath() + "/src/main/resources";
    }

    /**
     * 获取AutoGenerator
     */
    protected AutoGenerator getAutoGenerator(String tableName, String prefix,String author) {
        return new AutoGenerator()
                // 全局配置
                .setGlobalConfig(getGlobalConfig(author))
                // 数据源配置
                .setDataSource(getDataSourceConfig())
                // 策略配置
                .setStrategy(getStrategyConfig(tableName, prefix))
                // 包配置
                .setPackageInfo(getPackageConfig());
        // 模板配置
        //.setTemplate(getTemplateConfig());
    }

}
