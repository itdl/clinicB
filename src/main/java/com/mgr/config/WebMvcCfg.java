package com.mgr.config;

import com.mgr.filter.SessionIntercepter;
import com.mgr.util.GlobalVar;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;


/**
 * 添加拦截器
 * @author
 * @time 2017/3/9.
 */
@Configuration
public class WebMvcCfg extends WebMvcConfigurerAdapter {

    @Resource
    private SessionIntercepter sessionIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionIntercepter).addPathPatterns(GlobalVar.URLS).excludePathPatterns(GlobalVar.LGNURL);
    }
}
