package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {
	public int[] retrieveData() {
		return new int[] { 11, 12, 13, 14, 15 };
	};
}
