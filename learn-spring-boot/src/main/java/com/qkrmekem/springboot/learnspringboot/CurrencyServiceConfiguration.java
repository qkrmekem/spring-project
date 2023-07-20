package com.qkrmekem.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
properties(profile 적용)
@ConfigurationProperties(prefix = "currency-service")의 prefix값+필드명으로
properties의 값과 매핑함

currency-service.url=
currency-service.username=
currency-service.key=
*/

// properties값과 매칭할 때 사용
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
