package com.rnb.scp.entity;

import javax.persistence.*;

@Entity
@Table	(name="rnbBooking")

public class RNB_Booking {
	
	// Initialization of variable 
	// Define column names of database 
	
	// Auto generated ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//First name of customer
	@Column(name="first_name")
	private String str_firstName;
	
	//Last name of customer
	@Column(name="last_name")
	private String str_lastName;
		
	//Booking date
	@Column(name="Booking_date")
	private String str_bookingDate;
	
	//Booking time
	@Column(name="Booking_Time")
	private String str_bookingTime;
	
	//Number of person
	@Column(name="No_of_Person")
	private String str_person;
	
	//EmailID of customer
	@Column(name="Email")
	private String str_emailID;
	
	//Contact number of customer
	@Column(name="Contact")
	private String str_contact;
	
	
	// Default constructor
	public RNB_Booking()
	{
		
	}
	
	//Parameterized constructor
	
	public RNB_Booking(String str_fn, String str_ln, String str_date,String str_time, String str_per, String str_email, String str_con)
	{
		super();
		this.str_firstName = str_fn;
		this.str_lastName = str_ln;
		this.str_bookingDate = str_date;
		this.str_bookingTime = str_time;
		this.str_person = str_per;
		this.str_emailID = str_email;
		this.str_contact = str_con;
	}

	// Get and set methods for above defined variable
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStr_firstName() {
		return str_firstName;
	}

	public void setStr_firstName(String str_firstName) {
		this.str_firstName = str_firstName;
	}

	public String getStr_lastName() {
		return str_lastName;
	}

	public void setStr_lastName(String str_lastName) {
		this.str_lastName = str_lastName;
	}

	public String getStr_bookingDate() {
		return str_bookingDate;
	}

	public void setStr_bookingDate(String str_bookingDate) {
		this.str_bookingDate = str_bookingDate;
	}

	public String getStr_bookingTime() {
		return str_bookingTime;
	}

	public void setStr_bookingTime(String str_bookingTime) {
		this.str_bookingTime = str_bookingTime;
	}

	public String getStr_person() {
		return str_person;
	}

	public void setStr_person(String str_person) {
		this.str_person = str_person;
	}

	public String getStr_emailID() {
		return str_emailID;
	}

	public void setStr_emailID(String str_emailID) {
		this.str_emailID = str_emailID;
	}

	public String getStr_contact() {
		return str_contact;
	}

	public void setStr_contact(String str_contact) {
		this.str_contact = str_contact;
	}
	
	

}
