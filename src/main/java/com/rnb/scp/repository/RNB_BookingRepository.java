package com.rnb.scp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rnb.scp.entity.RNB_Booking;

@Repository
public interface RNB_BookingRepository  extends JpaRepository<RNB_Booking, Long> {
	
	

}
