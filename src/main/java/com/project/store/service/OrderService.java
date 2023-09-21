package com.project.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.store.model.Order;
import com.project.store.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final long maxNumberOfItems;
	
	public OrderService(OrderRepository orderRepository,
            @Value("${products.service.max-number-of-items:25}") long maxNumberOfItems) {
		this.orderRepository = orderRepository;
		this.maxNumberOfItems = maxNumberOfItems;
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(String.format("Order with id %s doesn't exist", id)));
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteOrderById(Long id) {
		orderRepository.deleteById(id);
	}
	
	public void placeOrders(Iterable<Order> orders) {
    	validateNumberOfItemsOrdered(orders);
        orderRepository.saveAll(orders);
    }
	
	private void validateNumberOfItemsOrdered(Iterable<Order> orders) {
        long totalNumberOfItems = 0;
        for (Order order: orders)  {
            totalNumberOfItems += order.getQuantity();
        }
        if (totalNumberOfItems > maxNumberOfItems) {
            throw new IllegalStateException(String.format("Number of products %d exceeded the limit of %d",
                    totalNumberOfItems, maxNumberOfItems));
        }
    }
	
}
