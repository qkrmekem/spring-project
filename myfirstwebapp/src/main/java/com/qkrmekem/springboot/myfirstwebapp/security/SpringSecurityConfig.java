package com.qkrmekem.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

    //    가변 인자로 여러개 삽입 가능
    //    InMemoryUserDetailsManager(UserDetails... userDetails)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails1 = createNewUser("qkrmekem", "dummy");
        UserDetails userDetails2 = createNewUser("pem", "dummydummy");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 솔트(salt)를 부여하여 여러번 해싱하여 암호화
        // 여기서 솔트란 해시함수에서 단방향 암호화를 할 때 추가적으로 들어가는 랜덤 데이터
        return new BCryptPasswordEncoder();
    }
    // 스프링 시큐리티는 기본적으로
    // 1. 모든 url은 보호됨
    // 2. 승인되지 않은 요청에 대해서는 로그인 양식이 표시됨
    // 3. CSRF 비활성화 되어 있음
    // html에서는 frame을 사용할 수 있는데
    // h2또한 frame을 사용하고 있음
    // 따라서 frame을 허용해줘야함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 요청을 여기서 승인
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // 승인되지 않은 요청은 로그인폼으로 이동
        http.formLogin(withDefaults());

        // spring security 6.1이후 버전에서는 아래의 방식은 더 이상 지원되지 않음
//        http.csrf().disable();
//        http.headers().frameOptions().disable();

        // 따라서 아래의 람다식을 이용해 구현해야 함
        // 공식 문서 : https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#headers(org.springframework.security.config.Customizer)
        // csrf란? https://itstory.tk/entry/CSRF-%EA%B3%B5%EA%B2%A9%EC%9D%B4%EB%9E%80-%EA%B7%B8%EB%A6%AC%EA%B3%A0-CSRF-%EB%B0%A9%EC%96%B4-%EB%B0%A9%EB%B2%95
        http.csrf((csrf) -> csrf.disable());
        http.headers(
                (headers) -> headers.frameOptions(
                        (frameOptions) -> frameOptions.disable()));
        return http.build();
    }
}
