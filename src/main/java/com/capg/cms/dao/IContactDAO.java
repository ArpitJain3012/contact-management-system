package com.capg.cms.dao;

import java.util.List;

import com.capg.cms.entity.Contact;
import com.capg.cms.exception.CMSException;

public interface IContactDAO {
	Contact add(Contact contact) throws CMSException;
	Contact save(Contact contact) throws CMSException;
	boolean	deleteById(long contactid) throws CMSException;
	Contact getById(long contactid) throws CMSException;
	List<Contact> getAll() throws CMSException;
	
	String INSERT_CONTACT= "INSERT INTO contact(cid,cname,dob,mobile) VALUES(?,?,?,?)";
	String UPDATE_CONTACT="UPDATE contact SET cname = ? dob = ? mobile = ? WHERE cid = ?";
	String DELETE_CONTACT="DELETE FROM contact WHERE cid = ?";
	String GET_CONTACT_BY_ID="SELECT cid,cname,dob,mobile FROM contact WHERE cid = ?";
	String GET_ALL_CONTACTS="SELECT cid,cname,dob,mobile FROM contact";
}
