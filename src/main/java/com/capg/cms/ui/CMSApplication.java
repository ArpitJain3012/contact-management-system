package com.capg.cms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.capg.cms.entity.Contact;
import com.capg.cms.exception.CMSException;
import com.capg.cms.service.ContactServiceImpl;
import com.capg.cms.service.IContactService;

public class CMSApplication {
	public static final Scanner sc=new Scanner(System.in);
	public static final IContactService contactservice= new ContactServiceImpl();
	
	public static void doAdd() {
		Contact contact = new Contact();
		System.out.println("Enter contact id : ");
		contact.setContactid(sc.nextLong());
		System.out.println("Enter full name : ");
		contact.setFullname(sc.next());
		System.out.println("Enter date of birth (yyyy-mm-dd) : ");
		contact.setDateofbirth(LocalDate.parse(sc.next()));
		System.out.println("Enter mobile num : ");
		contact.setMobile(sc.next());
		
		try {
			contactservice.add(contact);
			System.out.println("contact added ");
		}catch(CMSException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void doFind() {
		try {
		System.out.println("Enter contact id : ");
		long contactid=sc.nextLong();
		Contact contact;
			contact = contactservice.getById(contactid);
			
			if(contact==null) {
				System.out.println("no contact ");
			}else {
				System.out.println(contact);
			}
		} catch (CMSException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static  void doList() {
		try {
			List<Contact> contacts=contactservice.getAll();
			if(contacts.isEmpty())
			{
				System.out.println("no contact ");
			}else {
				for(Contact con:contacts)
					System.out.println(con);
			}
			
		}catch (CMSException e) {
			System.out.println(e.getMessage());
		}
	
}
	public static void doDelete() {
		try {
			System.out.println("Enter contact id : ");
			long contactid=sc.nextLong();
			boolean isDeleted =contactservice.deleteById(contactid);
			if(!isDeleted) {
				System.out.println("no contact ");
			}else {
				System.out.println("contact wit# "+contactid+" is deleted ");
			}
			
		}catch (CMSException e) {
			System.out.println(e.getMessage());
		}
	
}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Menu[] menus=Menu.values();
		Menu selectedmenu=null;
		while(selectedmenu!=Menu.QUIT) {
			System.out.println("\nChoice\tOperation");
			for(Menu m:menus) {
				System.out.println(m.ordinal() + "\t" + m);
			}
			System.out.println("Enter Choice : ");
			int ch= sc.nextInt();
			
			if(ch>=0 && ch<=menus.length) {
				selectedmenu = menus[ch];
				
				switch(selectedmenu) {
				case ADD : 
					doAdd();
					break;
				case FIND : 
					doFind();
					break;
				case LIST : 
					doList();
					break;
				case DELETE : 
					doDelete();
					break;
				case QUIT:
					break;
				}
			}else {
				selectedmenu =null;
				System.out.println("Invalid Choice");
			}
		}
		sc.close();
		System.out.println("Application Terminated");
	}

}
