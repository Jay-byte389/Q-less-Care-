package com.app.service;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.dao.BillDao;
import com.app.dao.PatientDao;
import com.app.dao.ServiceDao;
import com.app.dto.CreateBillDTO;
import com.app.pojos.Bill;
import com.app.pojos.Patient;
import com.app.pojos.Service;

@org.springframework.stereotype.Service
@Transactional
@CrossOrigin
public class BillServiceImpl implements BillService{
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private BillDao billdao;
	@Autowired
	private ServiceDao servicedao;

	@Override
	public int saveBill(CreateBillDTO bill) {
		Patient p = patientDao.findById(bill.getP_id()).orElse(null);
		Bill b = new Bill();
		p.addBill(b);
		b.setBillDate(LocalDate.now());
		b.setStatus("unpaid");
		int total=0;
		for(int i : bill.getServices()) {
			Service s=servicedao.findById(i).orElse(null);
			total = total + s.getCharges();
			b.addService(s);
		}
		b.setTotal(total);
		billdao.save(b);
		return b.getId();
	}
	
	@Override
	
	
	public Bill findBillById(int bill_id) {
		
		
		return billdao.findById(bill_id).orElse(null);
		
	}




	@Override
	public void save(Bill b) {
	billdao.save(b);
		
	}

 public List<Bill> getAllBills() {
        return billdao.findAll();
    }

    public Bill getBillById(int id) {
        return billdao.findById(id).orElse(null);
    }

    public Bill saveBill(Bill bill) {
        return billdao.save(bill);
    }

    public void deleteBill(int id) {
        billdao.deleteById(id);
    }

	@Override
	public List<Bill> findbillsByPatient(Patient p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findbillsByPatient'");
	}
}


