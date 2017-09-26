package com.mgr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 参数配置文件读取
 * @author
 * @time 2017/3/3.
 */
@Configuration
@PropertySource("classpath:param.properties")
public class ParamFileCfg {}