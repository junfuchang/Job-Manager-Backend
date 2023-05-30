package com.job.common.domain.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    /**
     * JWT加密秘钥信息
     */
    private String secret;

    /**
     * Token过期时间，默认为3天
     */
    private Long ttl;

    /**
     * token的签发者
     */
    private String issuer;

    /**
     * token名称；accessToken
     */
    private String name;
}
