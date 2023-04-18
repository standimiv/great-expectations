package com.expectations;

import lombok.Data;

@Data
public class Ingredient {
	
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		SIZE, DOUGH, MEAT, VEGETABLES, CHEESE, SAUCE, SEASONING  
	}
}
