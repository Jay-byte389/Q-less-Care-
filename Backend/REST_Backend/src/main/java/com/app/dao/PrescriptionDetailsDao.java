package com.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.PrescriptionDetails;

public interface PrescriptionDetailsDao extends JpaRepository<PrescriptionDetails, Integer> {

	
}
