package com.project.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "orders")
public class Order {
	
	/*
	 * The following entity is for orders
	 * 
	 * Id
	 * First Name
	 * Last Name
	 * Email
	 * Shipping Address
	 * Quantity
	 * Credit Card
	 * Course (Entity object)
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(name = "Order Id", example = "1")
    private Long id;

	@Column(nullable = false)
	@Schema(name = "Order First Name", example = "Saul")
    private String firstName;
	
	@Column(nullable = false)
	@Schema(name = "Order Last Name", example = "Gomez")
    private String lastName;
	
	@Column(nullable = false)
	@Schema(name = "Order Email", example = "sa@email.com")
    private String email;
	
	@Column(nullable = false)
	@Schema(name = "Order Shipping Address", example = "123 Address")
    private String shippingAddress;
	
	@Column(nullable = false)
	@Schema(name = "Order Quantity", example = "1")
    private Long quantity;
	
	@Schema(name = "Order Credit Card", example = "7777666655554444")
    private String creditCard;
    
    @ManyToOne
    @JoinColumn(name = "fk_course", nullable=false)
    @Schema(name = "Order Course")
    private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Order() {
    }

	public Order(String firstName, String lastName, String email, String shippingAddress, Long quantity,
			String creditCard, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.quantity = quantity;
		this.creditCard = creditCard;
		this.course = course;
	}
  
}
