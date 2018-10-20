package com.cg.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.util.ConnectionProvider;

public class ContactBookDaoImpl implements ContactBookDao{
	private Connection conn = new ConnectionProvider().getDBConnection();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO enquiry(enqryid,firstname,lastname,contactno,domain,city)"
					+ "VALUES(enquiries.nextval,?,?,?,?,?)";
					PreparedStatement pstmt1 = conn.prepareStatement(sql);
			
					pstmt1.setString(1, enqry.getfName());
					System.out.println(enqry.getfName()+"dfdsfdsafdsfdgfdsafds");
					pstmt1.setString(2, enqry.getlName());
					pstmt1.setString(3, enqry.getContactNo());
					pstmt1.setString(4, enqry.getpDomain());
					pstmt1.setString(5, enqry.getpLocation());
					pstmt1.executeUpdate();
					conn.commit();
					System.out.println(enqry);
					PreparedStatement pstmt2 = conn.prepareStatement("SELECT MAX(enqryid) FROM enquiry");
					ResultSet rs = pstmt2.executeQuery();
					rs.next();
					int enquiryId= rs.getInt(1);
					return enquiryId;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException {
		try {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM enquiry WHERE enqryid=1006";
			PreparedStatement pstmt2 = conn.prepareStatement(sql);
			ResultSet demandRS = pstmt2.executeQuery();
			if(demandRS.next()){
				String fName = demandRS.getString("firstname");
				String lName = demandRS.getString("lastname");
				String contactNo = demandRS.getString("contactno");
				String pDomain = demandRS.getString("domain");
				String pLocation = demandRS.getString("city");
				EnquiryBean enquirybean1=new EnquiryBean(fName,lName,contactNo,pDomain,pLocation);
				System.out.println(enquirybean1);
				return enquirybean1;
			}
		} catch (SQLException e) {
			try {
				e.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			conn.rollback();
		}finally{
			conn.setAutoCommit(true);
		}
		
		return null;
	}

}