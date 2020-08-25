package com.dcy.log.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2019/9/19 9:29
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "dcy.trace")
@RefreshScope
public class TraceProperties {
    /**
     * 是否开启日志链路追踪
     */
    private Boolean enable = Boolean.TRUE;
}
