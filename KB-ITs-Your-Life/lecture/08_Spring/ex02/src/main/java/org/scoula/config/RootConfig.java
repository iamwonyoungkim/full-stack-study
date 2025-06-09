package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 일반 설정. 어디에서든지 써먹을 설정들
@Configuration
@ComponentScan(basePackages = {"org.scoula"})
public class RootConfig {
}