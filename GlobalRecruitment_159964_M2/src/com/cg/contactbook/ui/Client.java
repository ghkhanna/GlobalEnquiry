package com.cg.contactbook.ui;

import java.sql.SQLException;
import java.util.Scanner;
import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.dao.ContactBookDao;
import com.cg.contactbook.exceptions.BankingServicesDownException;
import com.cg.contactbook.exceptions.ContactBookException;
import com.cg.contactbook.service.ContactBookService;
import com.cg.contactbook.service.ContactBookServiceImpl;

public class Client {
	public static void main(String[] args) throws SQLException, ContactBookException {
		String fName,lName,pLocation,pDomain;
		String contactNo;
		int choice;
		Scanner ref = new Scanner(System.in);
			System.out.println("**********Global Recruitments*********");
			System.out.println("Enter your choice");
			System.out.println("1. Enter Enquiry Details");
			System.out.println("2. Enter Enquiry details on Id");
			System.out.println("0. Exit");
			System.out.println("*************");
			System.out.println("please enter a choice");
			choice = ref.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the first Name");
				fName = ref.next();
				System.out.println("Enter the Last Name");
				lName = ref.next();
				System.out.println("Enter the contact number");
				contactNo=ref.next();
				System.out.println("Enter the preferred Location");
				pLocation = ref.next();
				System.out.println("Enter the preferred Domain");
				pDomain = ref.next();
				ref.close();
				EnquiryBean enquirybean1=new EnquiryBean(fName,lName,contactNo,pLocation,pDomain) ;
				ContactBookService services = new ContactBookServiceImpl();
				/**/
					int enquryId = services.addEnquiry(enquirybean1);
					System.out.println("Thank You " + enquirybean1.getfName()+ lName + " your Unique id is " + enquryId + " we will contact you shortly");
				/*}*//*catch (BankingServicesDownException e){
					e.printStackTrace();
				}*/
				break;
			case 2:
				System.out.println("Enter the Enquiry no.");
				int enquiryNo=ref.nextInt();
				EnquiryBean enquirybean2=new EnquiryBean(enquiryNo);
				ContactBookService services1 = new ContactBookServiceImpl();
				EnquiryBean enquiry=services1.getEnquiryDetails(enquiryNo);
				System.out.println("Fname= " + enquiry.getfName());
				break;
					
	
			case 0:
				System.out.println("Thank You for your time!");
				break;
				default:
					break;
			
			
			}		
		}
	}