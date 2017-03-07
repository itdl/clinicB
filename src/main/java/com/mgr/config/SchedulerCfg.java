package com.mgr.config;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时器
 * @author
 * @time 2016/12/15.
 */
//@Component
public class SchedulerCfg {
    private final Logger logger = LoggerFactory.getLogger(SchedulerCfg.class);

    @Async("TpExecutor")
    @Scheduled(cron="0 0/10 5-23 ? * *")
    private void SchedulerInit(){
        logger.info("定时设置完成.");
    }
}
