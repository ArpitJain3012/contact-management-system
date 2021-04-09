package com.capg.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.cms.entity.Contact;
import com.capg.cms.exception.CMSException;
import com.capg.cms.util.ConnectionFactory;

public class ContactDAOImpl implements IContactDAO {

	@Override
	public Contact add(Contact contact) throws CMSException {
		if(contact !=null) {
			try(Connection con=ConnectionFactory.getconnection();
				PreparedStatement pst=con.prepareStatement(INSERT_CONTACT);){
				pst.setLong(1,contact.getContactid());
				pst.setString(2, contact.getFullname());
				pst.setDate(3, Date.valueOf(contact.getDateofbirth()));
				pst.setString(4, contact.getMobile());
				pst.executeUpdate();
			}catch(SQLException excep) {
				throw new CMSException("contact could not be saved");
			}
		}
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws CMSException {
		if(contact !=null) {
			try(Connection con=ConnectionFactory.getconnection();
				PreparedStatement pst=con.prepareStatement(UPDATE_CONTACT);){
				pst.setString(1, contact.getFullname());
				pst.setDate(2, Date.valueOf(contact.getDateofbirth()));
				pst.setString(3, contact.getMobile());
				pst.setLong(4,contact.getContactid());
				pst.executeUpdate();
		}catch(SQLException excep) {
			throw new CMSException("contact could not be updated");
		}
		}
		return contact;
	}
	
	@Override
	public boolean deleteById(long contactid) throws CMSException {
		boolean isDeleted=false;
			try(Connection con=ConnectionFactory.getconnection();
				PreparedStatement pst=con.prepareStatement(DELETE_CONTACT);){
				pst.setLong(1,contactid);
				int rowcount=pst.executeUpdate();
				isDeleted=rowcount>0;
		}catch(SQLException excep) {
			throw new CMSException("contact could not be deleted");
		}
		return isDeleted;
	}

	@Override
	public Contact getById(long contactid) throws CMSException {
		Contact contact=null;
		try(Connection con=ConnectionFactory.getconnection();
		PreparedStatement pst=con.prepareStatement(GET_CONTACT_BY_ID);){
		
			pst.setLong(1,contactid);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				contact =new Contact();
				contact.setContactid(rs.getLong(1));
				contact.setFullname(rs.getString(2));
				contact.setDateofbirth(rs.getDate(3).toLocalDate());
				contact.setMobile(rs.getString(4));
			}
		}catch(SQLException excep) {
				throw new CMSException("contact could not be reterieved");
			}
		return contact;
	}

	@Override
	public List<Contact> getAll() throws CMSException {
		List<Contact> contacts=new ArrayList<>();
		
		try(Connection con=ConnectionFactory.getconnection();
				PreparedStatement pst=con.prepareStatement(GET_ALL_CONTACTS);){
				
					ResultSet rs= pst.executeQuery();
					while(rs.next()) {
						Contact contact =new Contact();
						contact.setContactid(rs.getLong(1));
						contact.setFullname(rs.getString(2));
						contact.setDateofbirth(rs.getDate(3).toLocalDate());
						contact.setMobile(rs.getString(4));
						contacts.add(contact);
					}
					if(contacts.isEmpty())
					{
						contacts=null;
					}
				}catch(SQLException excep) {
						throw new CMSException("contact list could not be reterieved");
					}
		return contacts;
	}
	}


