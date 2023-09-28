package com.project.store.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckoutRequest {

	/*
	 * The following class is to help us build a new record of the Order entity
	 * 
	 * First Name
	 * Last Name
	 * Email
	 * Shipping Address
	 * Credit Card
	 * CourseInfo (SubClass):
	 * 		Course Id
	 * 		Quantity
	 */
	
	@Schema(name = "Order First Name", example = "Saul")
	private String firstName;
	
	@Schema(name = "Order Last Name", example = "Gomez")
    private String lastName;
	
	@Schema(name = "Order Email", example = "sa@email.com")
    private String email;
	
	@Schema(name = "Order Shipping Address", example = "123 Address")
    private String shippingAddress;
	
	@Schema(name = "Order Course")
    private List<CourseInfo> course;
	
	@Schema(name = "Order Credit Card", example = "7777666655554444")
    private String creditCard;
    
    public List<CourseInfo> getCourse() {
		return course;
	}

	public void setCourse(List<CourseInfo> course) {
		this.course = course;
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

	public CheckoutRequest(String firstName, String lastName, String email, String shippingAddress,
			List<CourseInfo> course, String creditCard) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.course = course;
		this.creditCard = creditCard;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
 
    public static class CourseInfo {
        
    	@Schema(name = "Course Id", example = "1")
    	private long courseId;
    	
    	@Schema(name = "Course Quantity", example = "1")
        private long quantity;
		
		public long getCourseId() {
			return courseId;
		}
		public void setCourseId(long courseId) {
			this.courseId = courseId;
		}
		public long getQuantity() {
			return quantity;
		}
		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}
		
		public CourseInfo(long courseId, long quantity) {
			super();
			this.courseId = courseId;
			this.quantity = quantity;
		}
        
    }
}
