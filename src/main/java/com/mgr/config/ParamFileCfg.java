package com.mgr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 参数配置文件读取
 * @author song
 * @time 2017/3/3.
 */
@Configuration
@PropertySource("classpath:param.properties")
public class ParamFileCfg {}