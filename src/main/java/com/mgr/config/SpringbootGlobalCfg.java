package com.mgr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springboot全局配置类。
 * 开启事务支持
 * 容器配置
 */
@Configuration
@EnableTransactionManagement
public class SpringbootGlobalCfg {}
