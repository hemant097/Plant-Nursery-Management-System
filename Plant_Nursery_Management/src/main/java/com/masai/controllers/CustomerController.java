package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.OrderException;
import com.masai.Exceptions.UserAlreadyExists;
import com.masai.ServiceLayer.CustomerService;
import com.masai.ServiceLayer.OrderService;
import com.masai.ServiceLayer.UserLoginLogoutService;
import com.masai.ServiceLayer.UserService;
import com.masai.models.Customer;
import com.masai.models.CustomerOrder;
import com.masai.models.User;
import com.masai.models.UserDTO;

@RestController
@RequestMapping("/user")
public class CustomerController {
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserLoginLogoutService loginLogOutService;
	
	@Autowired
	private OrderService orderService;

	
	@PostMapping("/adduser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws UserAlreadyExists{
		
		User savedUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@Valid @RequestBody UserDTO userDTO) throws UserAlreadyExists{
		
		String savedUser = loginLogOutService.userLogin(userDTO);
		
		return new ResponseEntity<String>(savedUser,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(
			@Valid @RequestBody User user,@RequestParam(required = false) 
			String key
			) throws UserAlreadyExists{
		
		User updatedUser = userService.updateUserCredential(user, key);
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> userLogOut(@RequestParam(required = false) 
	String key) throws UserAlreadyExists{
		
		String loggedOutUser = userService.userLogout(key);
		
		return new ResponseEntity<String>(loggedOutUser,HttpStatus.OK);
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> saveCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException, UserAlreadyExists {

		Customer savedCustomer = cService.addCustomer(customer);

		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomerHandler
			(@Valid @RequestBody Customer customer,@RequestParam(required = false) 
				String key) throws CustomerException{
		
		Customer updatedCustomer=cService.updateCustomer(customer,key);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);		
		
	}

	
	//--------------------------------------------ORDER____________________------
	
	@PostMapping("/order/add")
	public ResponseEntity<CustomerOrder> addOrder
			(@Valid @RequestBody CustomerOrder cOrder) throws OrderException{
		
		CustomerOrder newOrder  = orderService.addOrder(cOrder);
		
		return new ResponseEntity<CustomerOrder>(newOrder,HttpStatus.OK);	
	}
	
	@PutMapping("/order/update")
	public ResponseEntity<CustomerOrder> updateOrder
			(@Valid @RequestBody CustomerOrder cOrder) throws OrderException{
		
		CustomerOrder updatedOrder  = orderService.updateOrder(cOrder);
		
		return new ResponseEntity<CustomerOrder>(updatedOrder,HttpStatus.OK);	
	}
	
	@DeleteMapping("/order/delete/{oID}")
	public ResponseEntity<CustomerOrder> deleteOrder
			(@PathVariable Integer oID) throws OrderException{
		
		CustomerOrder deletedOrder  = orderService.deleteOrderById(oID);
		
		return new ResponseEntity<CustomerOrder>(deletedOrder,HttpStatus.OK);	
	}
	
	@DeleteMapping("/order/view/{oID}")
	public ResponseEntity<CustomerOrder> viewOrder
			(@PathVariable Integer oID) throws OrderException{
		
		CustomerOrder viewOrder  = orderService.deleteOrderById(oID);
		
		return new ResponseEntity<CustomerOrder>(viewOrder,HttpStatus.OK);	
	}
}
