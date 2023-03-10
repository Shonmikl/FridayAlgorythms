package unit.dummy;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Customer {
	String fname;
	String lName;
	Address address;
}