package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CartException;
import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.PlanterException;
import com.masai.ServiceLayer.CartService;
import com.masai.ServiceLayer.CustomerService;
import com.masai.ServiceLayer.PlantService;
import com.masai.ServiceLayer.PlanterService;
import com.masai.ServiceLayer.SeedService;
import com.masai.ServiceLayer.UserLoginLogoutService;
import com.masai.ServiceLayer.UserService;
import com.masai.models.Cart;
import com.masai.models.Planter;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CustomerService cService;
	@Autowired
	private UserLoginLogoutService userLoginLogOutService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginLogoutService loginLogOutService;
	@Autowired 
	private SeedService seedService;
	@Autowired
	private PlantService plantService;
	@Autowired
	private PlanterService planterService;
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/add/{customerID}/{planterID}")
	public ResponseEntity<Cart> saveNewProductInCart(@RequestBody Cart cart
			,@PathVariable Integer customerID
			,@PathVariable Integer planterID)
			throws CustomerException,CartException{
	
		Cart addedToCart = cartService.addToCart(customerID, planterID, cart);
		
		
	return new ResponseEntity<Cart>(addedToCart,HttpStatus.OK);
			
}
	
	@GetMapping("/all")
	public ResponseEntity<List<Planter>> seeAllItemsInCart()
			throws CustomerException,CartException{
	
		List<Planter> planters = cartService.getAllItem();
		
		
	return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
			
}
	
	@DeleteMapping("/{cartID}/{planterID}")
	public ResponseEntity<String> deleteItemFromCart(
	@PathVariable Integer cartID,@PathVariable Integer planterID)
			throws CustomerException,CartException, PlanterException{
	
	String output = cartService.deleteFromCart(cartID, planterID);		
		
	return new ResponseEntity<String>(output,HttpStatus.OK);
			
}
	
	@DeleteMapping("/removeAll")
	public ResponseEntity<String> deleteAll(){
	
	String output = cartService.emptyCart();		
		
	return new ResponseEntity<String>(output,HttpStatus.OK);
			
}
}