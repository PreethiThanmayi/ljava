package com.capgemini.mps.dao;

public interface QueryMapper {
public static final String RETRIEVE_ALL_MOBILES="SELECT * from mobiles";
public static final String DELETE_MOBILE="DELETE FROM mobiles WHERE mobileid=?";
public static final String QUERY_MOBILE_RANGE="SELECT * from mobiles where price>=? AND price<=?";
public static final String CHECK_VALID_MOBILEID="SELECT * FROM mobiles where mobileid=?";
public static final String ADD_PURCHASE_DETAILS="insert into purchaseDetails values(purchaseid_sequence.NEXTVAL,?,?,?,SYSDATE,?)";
public static final String RETRIEVE_MOBILE="SELECT * from mobiles where mobileid=?";
public static final String UPDATE_MOBILE_QUANTITY="UPDATE mobiles set quantity=quantity-? where mobileId=?";
public static final String RETRIVE_PURCHASEID="SELECT purchaseid_sequence.CURRVAL from dual";
}
