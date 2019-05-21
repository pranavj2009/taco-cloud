package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Ingredient {
	
	private final String id;
	private final String name;
	private final String type;
	
	private static enum Type{
			WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
	}	
		
}
