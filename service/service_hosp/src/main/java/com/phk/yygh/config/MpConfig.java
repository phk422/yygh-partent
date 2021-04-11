package com.phk.yygh.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/4/11
 **/
@Configuration
@MapperScan("com.phk.yygh.mapper")
public class MpConfig {

    // 分页插件配置
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
