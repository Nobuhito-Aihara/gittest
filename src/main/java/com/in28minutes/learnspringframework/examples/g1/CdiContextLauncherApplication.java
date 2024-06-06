package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Componentアノテーションをつけたクラスを検出し、beanとしてspringが生成する。
//@Component
@Named
class BusinessService {
	private DataService dataService;

	@Autowired // セッターインジェクション
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}

}

//@Component
@Named
class DataService {

}

//クラス名にpublicとつけてよいのはクラス名とファイル名が一致する場合のみ
//springのconfigファイルを作成し、内部にbeanを定義している。
@Configuration
//@ComponentScanでは、何もつけなければ現在のパッケージがスキャンされる。パッケージ名を指定すればそれを読み込む。
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);

			System.out.println(context.getBean(BusinessService.class)
					.getDataService());

		}

	}
}