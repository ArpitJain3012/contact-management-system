package com.capg.cms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capg.cms.dao.ContactDAOImpl;
import com.capg.cms.dao.IContactDAO;
import com.capg.cms.entity.Contact;
import com.capg.cms.exception.CMSException;

public class ContactServiceImpl implements IContactService {
	
	private IContactDAO contactDAO;
	
	public ContactServiceImpl() {
		contactDAO =new ContactDAOImpl();
	}
	
	public boolean isValidContactId(Long contactId) {
		return contactId !=null && contactId>0;
	}
	
	public boolean isValidFullName(String fullname) {
		return fullname != null && (fullname.length()>=3 || fullname.length()<=20);
	}
	
	public boolean isValidDateOfBirth(LocalDate dob) {
		return dob !=null && dob.isBefore(LocalDate.now());
	}
	
	public boolean isValidMobile(String mobile) {
		return mobile !=null && mobile.matches("[1-9][0-9]{9}");
	}
	
	public boolean isValidContact(Contact contact) throws CMSException {
		List<String> error=new ArrayList<>();
		boolean isvalid=true;
		
		if(contact !=null) {
			if(!isValidContactId(contact.getContactid())) {
				isvalid=false;
				error.add("Contact id cannot be blanked and must be positive number");
			}
			if(!isValidFullName(contact.getFullname())) {
				isvalid=false;
				error.add("Contact name cannot be blanked and must be 3-20 characters");
			}
			if(!isValidDateOfBirth(contact.getDateofbirth())) {
				isvalid=false;
				error.add("date of birth cannot be blanked and must not be a future date");
			}
			if(!isValidMobile(contact.getMobile())) {
				isvalid=false;
				error.add("mobile number cannot be blank and must be 10 digits");
			}
			if(!error.isEmpty()) {
				throw new CMSException("Invalid Contact : " +error);
			}
		}else {
				isvalid=false;
				throw new CMSException("contact details are not supplied");
				}
		
		return isvalid;
	}
	
	@Override
	public Contact add(Contact contact) throws CMSException {
		if(isValidContact(contact))
		{
			contactDAO.add(contact);
		}
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws CMSException {
		
		if(isValidContact(contact))
		{
			contactDAO.save(contact);
		}
		return contact;
		
	}

	@Override
	public boolean deleteById(long contactid) throws CMSException {
		return contactDAO.deleteById(contactid);
	}

	@Override
	public Contact getById(long contactid) throws CMSException {
		return contactDAO.getById(contactid);
	}

	@Override
	public List<Contact> getAll() throws CMSException {
		return contactDAO.getAll();
	}

}
