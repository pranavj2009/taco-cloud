package tacos;

public class Ingredient {
	
	private final String id;
	private final String name;
	private final String type;
	
	private static enum Type{
			WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Ingredient(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
		
}
