package com.mgr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * @author
 * @time 2017/1/20.
 */
@Component
@EnableAsync
public class ThreadPoolCfg {
    @Autowired
    private ParamCfg paramCfg;
    @Bean
    public ThreadPoolTaskExecutor TpExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(paramCfg.getCoresize());
        executor.setKeepAliveSeconds(paramCfg.getKeepAliveTime());
        executor.setMaxPoolSize(paramCfg.getMaxsize());
        executor.setQueueCapacity(paramCfg.getQueueCapacity());
        executor.setThreadNamePrefix("Executor-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}