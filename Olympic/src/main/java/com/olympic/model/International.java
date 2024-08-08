package com.olympic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class International {
	private int id;
	private String name, flag, content;
	private int gold, silver, bronze;
	public International(String name, String flag, String content) {
		super();
		this.name = name;
		this.flag = flag;
		this.content = content;
	}
}
