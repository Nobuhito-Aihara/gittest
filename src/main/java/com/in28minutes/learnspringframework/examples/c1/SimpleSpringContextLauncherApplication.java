package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//publicとつけてよいのはクラス名とファイル名が一致する場合のみ
//springのconfigファイルを作成し、内部にbeanを定義している。
@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {

		// spring contextを作成する。
		try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}