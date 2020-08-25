package com.dcy.log.config;

import com.dcy.log.properties.TraceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author：dcy
 * @Description: 日志自动配置
 * @Date: 2019/9/19 9:30
 */
@EnableConfigurationProperties(TraceProperties.class)
public class LogAutoConfigure {
}
