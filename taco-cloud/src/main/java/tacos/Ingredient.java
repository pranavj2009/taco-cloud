package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Ingredient {

	private final String id;
	private final String name;
	private final Type type;
	private final FoodType foodType;

	public static enum Type {
		BREAD, BASE, VEGGIES, CHEESE, SAUCE;
	}

	public static enum FoodType {
		VEG, NONVEG, EGG;
	}
	
	

}
