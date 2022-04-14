package com.rnb.scp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.rnb.scp.exception.ResourceNotFoundException;
import com.rnb.scp.entity.RNB_Booking;
import com.rnb.scp.repository.RNB_BookingRepository;

@RestController
@RequestMapping("/api/rnbbookings") // URL of API
public class RNB_BookingController {
	
	@Bean
    public WebMvcConfigurer getCorsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
	
	@Autowired
	private RNB_BookingRepository rnb_bookingRepository;
	
	//Get all bookings
		@GetMapping("/all")
		public List <RNB_Booking> getAllBookings(){
			
			return this.rnb_bookingRepository.findAll();
		}
		
		// Get bookings by id
		@GetMapping("/{id}")
		public RNB_Booking getBookingById(@PathVariable (value = "id") long bookingId) {
					
		return this.rnb_bookingRepository.findById(bookingId).
					orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID :" + bookingId));
		}
		
		// Create booking record
		@PostMapping
		public RNB_Booking createBooking(@RequestBody RNB_Booking obj_booking) {
			
			return this.rnb_bookingRepository.save(obj_booking);
			
		}
		
		// Update booking record
		@PutMapping("/{id}")
		public RNB_Booking updateBooking(@RequestBody RNB_Booking obj_booking, @PathVariable("id") long ln_bookingId)
		{
			RNB_Booking existingbooking= this.rnb_bookingRepository.findById(ln_bookingId).
						orElseThrow(() -> new ResourceNotFoundException("Booking not found with receipt_no: "+ln_bookingId));
			existingbooking.setStr_firstName(obj_booking.getStr_firstName());
			existingbooking.setStr_lastName(obj_booking.getStr_lastName());
			existingbooking.setStr_bookingDate(obj_booking.getStr_bookingDate());
			existingbooking.setStr_bookingTime(obj_booking.getStr_bookingTime());
			existingbooking.setStr_person(obj_booking.getStr_person());
			existingbooking.setStr_emailID(obj_booking.getStr_emailID());
			existingbooking.setStr_contact(obj_booking.getStr_contact());
			 return this.rnb_bookingRepository.save(existingbooking);
				
			
		}
		
		//Delete booking record
		@DeleteMapping("/{id}")
		public ResponseEntity<RNB_Booking> deleteBooking(@PathVariable ("id") long ln_bookingId){
			
			RNB_Booking existing=this.rnb_bookingRepository.findById(ln_bookingId).
					orElseThrow(() -> new ResourceNotFoundException("Booking not found with receipt_no :" + ln_bookingId));
			
			this.rnb_bookingRepository.delete(existing);
			
			return ResponseEntity.ok().build();
			
		}
		

}
