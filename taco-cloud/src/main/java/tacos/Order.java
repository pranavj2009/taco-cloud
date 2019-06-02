package tacos;

import lombok.Data;

@Data
public class Order {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
}
