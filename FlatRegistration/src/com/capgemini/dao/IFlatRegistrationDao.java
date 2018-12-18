package com.capgemini.dao;

import java.util.List;

import com.capgemini.bean.FlatOwners;
import com.capgemini.bean.FlatRegistration;
import com.capgemini.exception.FlatException;

public interface IFlatRegistrationDao {
	
	/**
	 * 
	 * @param flatBean
	 * @return
	 * @throws FlatException
	 */
	
public int registerFlat(FlatRegistration flatBean) throws FlatException;
public List<Integer> getOwnerid()  throws FlatException;
}
