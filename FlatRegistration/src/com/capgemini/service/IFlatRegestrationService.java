package com.capgemini.service;

import java.util.List;

import com.capgemini.bean.FlatRegistration;
import com.capgemini.exception.FlatException;

public interface IFlatRegestrationService {
	
	
	
	public int registerFlat(FlatRegistration flatBean) throws FlatException;
	public List<Integer> getOwnerid()throws FlatException;

}
