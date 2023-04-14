package com.expectations;

import lombok.Data;

@Data
public class Ingredient {
	
	private String id;
	private String name;
	private Type type;
	
	public enum Type {
		DOUGH, SAUCE, MEAT, VEGETABLES, CHEESE, SEASONING  
	}
}
