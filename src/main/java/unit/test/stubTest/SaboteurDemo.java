//package unit.test.stubTest;//package javaProf.unit.mockito.test.stubTest;
//
//import org.example._2023_02_24.unit.stub.*;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class SaboteurDemo {
//
//	@Test
//	public void testInvalidCustomer() {
//	  Customer customer = new Customer();
//	  CustomerRepository customerRepository = mock(CustomerRepository.class);
//
//	  when(customerRepository.getCustomerById(anyLong()))
//	    					 .thenThrow(new CustomerNotFoundException());
//
//	  CustomerService customerService = new SimpleCustomerService(customerRepository);
//	  assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(customer.getId()));
//	}
//}