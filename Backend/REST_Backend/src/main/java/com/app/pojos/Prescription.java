package com.app.pojos;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="Prescription")
@ToString
public class Prescription extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="doctor_id",nullable = false)
	private Doctor doc;
	//owning side // child
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient; 
	
	private LocalDate date;
	
	@OneToMany(mappedBy ="prescriptionid", cascade =  CascadeType.ALL, orphanRemoval = true)
	private List<PrescriptionDetails> prescriptiondetails=new ArrayList<>();

	public Prescription() 
	{
		
	}

	public Prescription(Doctor doc, Patient patient, LocalDate date, List<PrescriptionDetails> prescriptiondetails) {
		super();
		this.doc = doc;
		this.patient = patient;
		this.date = date;
		this.prescriptiondetails = prescriptiondetails;
	}


	public Doctor getDoc() {
		return doc;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}

	

	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<PrescriptionDetails> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(List<PrescriptionDetails> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
	}

	public void addPrescriptiondetails(PrescriptionDetails p) {
		this.prescriptiondetails.add(p);
		p.setPrescriptionid(this);
	}
	
	
}
