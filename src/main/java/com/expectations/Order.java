package com.expectations;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	
	private String name;
	private String street;
	private String city;
	private String ccNum;
	private String ccExpiration;
	private String ccCVV;
	
	private List<Pizza> pizzas = new ArrayList<>();
	
	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

}
