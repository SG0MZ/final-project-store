package com.project.store.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.project.store.exception.CreditCardValidationException;
import com.project.store.model.CheckoutRequest;
import com.project.store.model.Order;
import com.project.store.service.CourseService;
import com.project.store.service.CreditCardValidationService;
import com.project.store.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("orders")
public class OrderController {

	/*
	 * With this controller we use the order services
	 * 
	 * getAllOrders
	 * modifyOrder (This returns a ResponseEntity in case the controller works or not)
	 * deleteOrderById (Included a try catch for EmptyResultDataAccessException, NumberFormatException and MethodArgumentTypeMismatchException)
	 * checkout (This returns a ResponseEntity in case the controller works or not, it will validate that the credit card, first name, and last name are correct)
	 * 
	 * In the Swagger UI you can test the requests. It will include a description, and examples on how to send the add and modify requests.
	 */
	
	private final OrderService orderService;
    private final CourseService courseService;
    private final CreditCardValidationService creditCardValidationService;
    
    public OrderController(OrderService orderService, CourseService courseService, CreditCardValidationService creditCardValidationService) {
    	this.orderService = orderService;
    	this.courseService = courseService;
    	this.creditCardValidationService = creditCardValidationService;
    }
    
    @Operation(summary = "Get All Orders", description = "Returns a list of all orders.")
    @GetMapping
    public List<Order> getAllOrders() {
    	return orderService.getAllOrders();
    }
    
    @Operation(summary = "Modify Order", description = "Updates a order.")
    @PutMapping
    public ResponseEntity<String> modifyOrder(@RequestBody Order order) {
    	if(orderService.getOrderById(order.getId()) == null)
    		return new ResponseEntity<>("Order id cant be null",
                    HttpStatus.NOT_FOUND);
    	orderService.saveOrder(order);
    	return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @Operation(summary = "Delete Order By Id", description = "Deletes a order by its id.")
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
		try {
			orderService.deleteOrderById(id);
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		} catch(MethodArgumentTypeMismatchException | NumberFormatException e1) {
			System.out.println(e1.getMessage());
		}
	} 
    
    @Operation(summary = "Add New Order", description = "Creates a new order.")
    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody CheckoutRequest checkoutRequest) {
        Set<Order> orders = new HashSet<>(checkoutRequest.getCourse().size());
        if(isNullOrBlank(checkoutRequest.getCreditCard())) {
            return new ResponseEntity<>("Credit card information is missing",
                                         HttpStatus.PAYMENT_REQUIRED);
        }
        if (isNullOrBlank(checkoutRequest.getFirstName())) {
            return new ResponseEntity<>("First name is missing", HttpStatus.BAD_REQUEST);
        }
        if (isNullOrBlank(checkoutRequest.getLastName())) {
            return new ResponseEntity<>("Last name is missing", HttpStatus.BAD_REQUEST);
        }
        creditCardValidationService.validate(checkoutRequest.getCreditCard());
        for (CheckoutRequest.CourseInfo courseInfo : checkoutRequest.getCourse()) {
     
            Order order = new Order(checkoutRequest.getFirstName(),
                    checkoutRequest.getLastName(),
                    checkoutRequest.getEmail(),
                    checkoutRequest.getShippingAddress(),
                    courseInfo.getQuantity(),
                    checkoutRequest.getCreditCard(),
                    courseService.getCourseById(courseInfo.getCourseId()));
            orders.add(order);
        }
        orderService.placeOrders(orders);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    
    /*
     * A brief boolean function to validate if a string is empty or not.
     */
    
    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty() || input.trim().length() == 0;
    }
    
    /*
     * A function that return a ResponseEntity when the credit card is invalid (either is because its not complete, or is a stolen card).
     */
    
    @ExceptionHandler({CreditCardValidationException.class})
    public ResponseEntity<String> handleCreditCardError(Exception ex) {
        System.out.println(String.format("Request to /checkout path threw an exception %s", ex.getMessage()));
        return new ResponseEntity<>("Credit card is invalid, please use another form of payment",
                HttpStatus.BAD_REQUEST);
    }
}
