package com.example.game.util;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DaoCodeGenerator {

    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/game_db?serverTimezone=Asia/Shanghai&useSSL=false");
        dataSource.setUsername("xxxx");
        dataSource.setPassword("xxxx");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {

        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.example.game");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateSchema("game_db")
                .setTablePrefix("")
                .setGenerateTable("user");// 表名

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.enableMapper();

        //设置生成 mapper - xml
        globalConfig.enableMapperXml();

        //设置生成 service
        globalConfig.enableService();

        //设置生成 serviceImpl
        globalConfig.enableServiceImpl();

        return globalConfig;
    }
}
