package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//publicとつけてよいのはクラス名とファイル名が一致する場合のみ
//springのconfigファイルを作成し、内部にbeanを定義している。
public class XmlConfigurationContextLauncherApplication {

	public static void main(String[] args) {

		// spring contextを作成する。
		try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
		}

	}

}