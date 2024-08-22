package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prescription_dtls")
public class PrescriptionDetails extends BaseEntity {

	@Column(length = 40)
	private String dosage;
	@Column(length=40)
	private String duration;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="prescription_id",nullable = false)
	private Prescription prescriptionid;
	@ManyToOne
	@JoinColumn(name="medicine_id",nullable = false)
	private Medicine medicineid;
	
	public PrescriptionDetails() {
		
	}

	public PrescriptionDetails(String dosage, String duration, int quantity, Prescription prescriptionid,
			Medicine medicineid) {
		super();
		this.dosage = dosage;
		this.duration = duration;
		this.quantity = quantity;
		this.prescriptionid = prescriptionid;
		this.medicineid = medicineid;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Prescription getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(Prescription prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public Medicine getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(Medicine medicineid) {
		this.medicineid = medicineid;
	}

	@Override
	public String toString() {
		return "PrescriptionDetails [dosage=" + dosage + ", duration=" + duration + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
	
}
