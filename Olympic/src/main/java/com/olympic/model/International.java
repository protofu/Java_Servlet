package com.olympic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class International {
	private int id;
	private String name, flag;
	private int gold, silver, bronze;
	public International(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
	}
}
