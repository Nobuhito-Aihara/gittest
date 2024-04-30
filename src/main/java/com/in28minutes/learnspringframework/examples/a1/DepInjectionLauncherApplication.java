package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Componentアノテーションをつけたクラスを検出し、beanとしてspringが生成する。
@Component
class YourBusinessClass {

	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("const");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	//	@Autowired
	//	public void setDependency1(Dependency1 dependency1) {
	//		System.out.println("setDependency1");
	//		this.dependency1 = dependency1;
	//	}
	//
	//	@Autowired
	//	public void setDependency2(Dependency2 dependency2) {
	//		System.out.println("setDependency2");
	//		this.dependency2 = dependency2;
	//	}

	public String toString() {
		return "Using " + dependency1 + " " + dependency2;
	}
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

//クラス名にpublicとつけてよいのはクラス名とファイル名が一致する場合のみ
//springのconfigファイルを作成し、内部にbeanを定義している。
@Configuration
//@ComponentScanでは、何もつけなければ現在のパッケージがスキャンされる。パッケージ名を指定すればそれを読み込む。
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		// spring contextを作成する。
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(YourBusinessClass.class));

		}

	}

}