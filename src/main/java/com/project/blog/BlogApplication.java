package com.project.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 상위 패키지를 스캔의 기준으로 한다.
import com.project.ComponentScanBasePackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Configuration, @EnableAutoConfiguration, @ComponentScan을 지정한 것과 동일
// 컴포넌트 구성과 자동 구성
@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})

@RestController
public class BlogApplication {

	@GetMapping("/")
	public String hello() {
		return "Hello World!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
