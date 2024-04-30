package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

// @Componentの記述があるファイルを捜索する。その際にディレクトリを指定して特定する。
@Component
public class PacmanGame implements GamingConsole {

	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("go down");
	}

	public void left() {
		System.out.println("Go left");
	}

	public void right() {
		System.out.println("Go right");
	}
}
