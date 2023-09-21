package com.project.store.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.project.store.exception.CreditCardValidationException;
import com.project.store.model.CheckoutRequest;
import com.project.store.model.Order;
import com.project.store.service.CourseService;
import com.project.store.service.CreditCardValidationService;
import com.project.store.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

	private final OrderService orderService;
    private final CourseService courseService;
    private final CreditCardValidationService creditCardValidationService;
    
    public OrderController(OrderService orderService, CourseService courseService, CreditCardValidationService creditCardValidationService) {
    	this.orderService = orderService;
    	this.courseService = courseService;
    	this.creditCardValidationService = creditCardValidationService;
    }
    
    @GetMapping
    public List<Order> getAllOrders() {
    	return orderService.getAllOrders();
    }
    
    @PutMapping
    public ResponseEntity<String> modifyOrder(@RequestBody Order order) {
    	if(orderService.getOrderById(order.getId()) == null)
    		return new ResponseEntity<>("Order id cant be null",
                    HttpStatus.NOT_FOUND);
    	orderService.saveOrder(order);
    	return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
		orderService.deleteOrderById(id);
	} 
    
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
    
    private static boolean isNullOrBlank(String input) {
        return input == null || input.isEmpty() || input.trim().length() == 0;
    }
    
    @ExceptionHandler({CreditCardValidationException.class})
    public ResponseEntity<String> handleCreditCardError(Exception ex) {
        System.out.println(String.format("Request to /checkout path threw an exception %s", ex.getMessage()));
        return new ResponseEntity<>("Credit card is invalid, please use another form of payment",
                HttpStatus.BAD_REQUEST);
    }
}
