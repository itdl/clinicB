package com.mgr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 参数配置读取工具类
 * @author song
 * @time2017/3/3.
 */
@Component
public class ParamCfg {
    @Value("${init.pthread.coresize}")
    private int corePoolSize;
    @Value("${init.pthread.keepalivetime}")
    private int keepAliveTime;
    @Value("${init.pthread.maxsize}")
    private int maxPoolSize;
    @Value("${init.pthread.queuecapacity}")
    private int queueCapacity;

    public int getCorePoolSize() {
        return corePoolSize;
    }
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }
    public int getKeepAliveTime() {
        return keepAliveTime;
    }
    public void setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }
    public int getMaxPoolSize() {
        return maxPoolSize;
    }
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
    public int getQueueCapacity() {
        return queueCapacity;
    }
    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
