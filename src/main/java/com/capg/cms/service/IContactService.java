package com.capg.cms.service;

import java.util.List;

import com.capg.cms.entity.Contact;
import com.capg.cms.exception.CMSException;

public interface IContactService {
	Contact add(Contact contact) throws CMSException;
	Contact save(Contact contact) throws CMSException;
	boolean	deleteById(long contactid) throws CMSException;
	Contact getById(long contactid) throws CMSException;
	List<Contact> getAll() throws CMSException;
	
	
}
