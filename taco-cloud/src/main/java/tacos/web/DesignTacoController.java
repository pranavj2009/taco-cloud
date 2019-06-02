package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.Ingredient.FoodType;
import tacos.Ingredient.Type;
import tacos.Taco;
import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesign(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("BRC", "Roasted Chicken", Type.BASE, FoodType.NONVEG),
			new Ingredient("BPT", "Paneer Tikka", Type.BASE, FoodType.VEG),
			new Ingredient("VTM", "Tomato", Type.VEGGIES, FoodType.VEG),
			new Ingredient("VON", "Onion", Type.VEGGIES, FoodType.VEG),
			new Ingredient("BMG", "Multigrain", Type.BREAD, FoodType.VEG),
			new Ingredient("BRG", "Roasted Garlic", Type.BREAD, FoodType.VEG),
			new Ingredient("SMM", "Mint Mayo", Type.SAUCE, FoodType.VEG),
			new Ingredient("SRC", "Red Chilly", Type.SAUCE, FoodType.VEG),
			new Ingredient("CMZ", "Mozzarella", Type.CHEESE, FoodType.VEG),
			new Ingredient("CPM", "Parmesan", Type.CHEESE, FoodType.VEG)
		);
		
		Type[] types = Ingredient.Type.values();
		
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
		}
		
		model.addAttribute("design", new Taco());
		return "design";
	}
	
	//tag::processDesignValidated[]
	  @PostMapping
	  public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
	    if (errors.hasErrors()) {
	      return "design";
	    }

	    // Save the taco design...
	    // We'll do this in chapter 3
	    log.info("Processing design: " + design);

	    return "redirect:/orders/current";
	  }

	//end::processDesignValidated[]
	
	public List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
	
}
