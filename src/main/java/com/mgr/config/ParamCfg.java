package com.mgr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 参数配置读取工具类
 * @author
 * @time2017/3/3.
 */
@Component
@ConfigurationProperties(prefix="init.pthread")
public class ParamCfg {
    private int coresize;
    private int keepalivetime;
    private int maxsize;
    private int queuecapacity;

    public int getCoresize() {
        return coresize;
    }
    public void setCoresize(int coresize) {
        this.coresize = coresize;
    }
    public int getKeepAliveTime() {
        return keepalivetime;
    }
    public void setKeepAliveTime(int keepalivetime) {
        this.keepalivetime = keepalivetime;
    }
    public int getMaxsize() {
        return maxsize;
    }
    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }
    public int getQueueCapacity() {
        return queuecapacity;
    }
    public void setQueueCapacity(int queuecapacity) {
        this.queuecapacity = queuecapacity;
    }
}
