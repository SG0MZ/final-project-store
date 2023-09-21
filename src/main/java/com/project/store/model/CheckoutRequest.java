package com.project.store.model;

import java.util.List;

public class CheckoutRequest {

	private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;
    private List<CourseInfo> course;
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
        
    	private long courseId;
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
