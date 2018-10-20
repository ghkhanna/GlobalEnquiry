package com.cg.contactbook.service;

import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.exceptions.ContactBookException;

public interface ContactBookService {
public int addEnquiry(EnquiryBean enqry) throws SQLException, ContactBookException;
public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ContactBookException;
public boolean ValidEnquiry(EnquiryBean enqry) throws ContactBookException;
}
