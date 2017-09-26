package com.mgr.config;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.mgr.service.YyconfigSrv;
import com.mgr.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
/**
 * 定时器
 * @author
 * @time 2016/12/15.
 */
@Component
public class SchedulerCfg {
    private final Logger logger = LoggerFactory.getLogger(SchedulerCfg.class);
    @Resource
    private YyconfigSrv yyconfigSrv;

    /**
     * 预约日期范围定时生成器
     */
    @Scheduled(cron="0 0 0 * * *")
    private void SchedulerInit(){
    }
}
