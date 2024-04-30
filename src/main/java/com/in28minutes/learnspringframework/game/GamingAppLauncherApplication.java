package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//publicとつけてよいのはクラス名とファイル名が一致する場合のみ
//springのconfigファイルを作成し、内部にbeanを定義している。
@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

	//	//	Pacmangameを作る → gamerunnerに配線する(引数に与える)
	//	@Bean
	//	public GamingConsole game() {
	//		var game = new PacmanGame();
	//		return game;
	//	}

	//	@Bean
	//	public GameRunner gameRunner(GamingConsole game) {
	//		var gameRunner = new GameRunner(game);
	//		return gameRunner;
	//	}

	public static void main(String[] args) {

		// spring contextを作成する。
		try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

			context.getBean(GamingConsole.class).up();

			// componentを読み込ませて、それについている@Qualifierで判別させている。
			context.getBean(GameRunner.class).run();
		}

	}

}