package com.expectations.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.expectations.Ingredient;
import com.expectations.Ingredient.Type;
import com.expectations.Order;
import com.expectations.Pizza;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/craft")
@SessionAttributes("order")
public class CraftPizzaController {
	
	@ModelAttribute
	public void addIngredientsToModel (Model model) {
		List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("SMAL", "Small", Type.SIZE),
			new Ingredient("LARG", "Large", Type.SIZE),
			new Ingredient("FMAL", "Family", Type.SIZE),
			new Ingredient("TRTC", "Traditional, Thin and Crispy", Type.DOUGH),
			new Ingredient("TRIT", "Traditional, Italian", Type.DOUGH),
			new Ingredient("TRAD", "Traditional", Type.DOUGH),
			new Ingredient("BACN", "Bacon", Type.MEAT),
			new Ingredient("PPSS", "Pepperoni/Spicy salami", Type.MEAT),
			new Ingredient("HAMM", "Ham", Type.MEAT),
			new Ingredient("AVOC", "Avocado", Type.VEGETABLES),
			new Ingredient("TOMS", "Tomatoes", Type.VEGETABLES),
			new Ingredient("LETT", "Lettuce", Type.VEGETABLES),
			new Ingredient("PROC", "Processed Cheese", Type.CHEESE),
			new Ingredient("PARM", "Parmesan", Type.CHEESE),	
			new Ingredient("MOZZ", "Mozzarella", Type.CHEESE),
			new Ingredient("TOMP", "Tomato puree", Type.SAUCE),
			new Ingredient("CREM", "Cream", Type.SAUCE),
			new Ingredient("BLCH", "Blue Cheese", Type.SAUCE),
			new Ingredient("HPJP", "Hot Pepper/Jalapeno", Type.SEASONING),
			new Ingredient("SAVR", "Savory", Type.SEASONING)				
				
		);
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}		
	}
	
	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute(name = "pizza")
	public Pizza pizza () {
		return new Pizza();
	}
	
	@GetMapping
	public String showCraftTemplate() {
		return "crafty";
	}
	
	private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(p -> p.getType().equals(type))
				.collect(Collectors.toList());
	}
	
		
		

}
