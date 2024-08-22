package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bill;


public interface BillDao extends JpaRepository<Bill, Integer>{
	
	// public List<Bill> findByPatient(Patient p);
	
}
