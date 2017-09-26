package com.mgr.config;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@Configuration
@WebListener
public class ServletContextCfg implements ServletContextListener {
	private final Logger logger = LoggerFactory.getLogger(ServletContextCfg.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                logger.info(String.format("ContextFinalizer:Driver %s deregistered", d));
            } catch (SQLException ex) {
            	logger.error(String.format("ContextFinalizer:Error deregistering driver %s", d), ex);
            }
        }
        try {
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
        	logger.error("ContextFinalizer:SEVERE problem cleaning up: " + e.getMessage(), e);
        }
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {}
}
