package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan Annotaion: 스프링이 스테레오 타입 Annotation이 지정된 클래스를 찾도록 지시함.
@ComponentScan(basePackages = "org.scoula.domain")
public class ProjectConfig3 {
}
