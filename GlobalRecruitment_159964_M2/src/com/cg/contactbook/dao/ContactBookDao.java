package com.cg.contactbook.dao;

import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.exceptions.ContactBookException;

public interface ContactBookDao {
public int addEnquiry(EnquiryBean enqry) throws SQLException, ContactBookException;
public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ContactBookException;
}
