package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.bean.FlatRegistration;
import com.capgemini.dao.FlatRegDaoImpl;
import com.capgemini.dao.IFlatRegistrationDao;
import com.capgemini.exception.FlatException;

public class FlatRegServImpl  implements IFlatRegestrationService{
	private IFlatRegistrationDao ifrDAO= new FlatRegDaoImpl();

	@Override
	public int registerFlat(FlatRegistration flatBean) throws FlatException {
		
		return 	ifrDAO.registerFlat(flatBean);
	}

	@Override
	public List<Integer> getOwnerid() throws FlatException {
	List<Integer> idList=new ArrayList<>();
		 idList= ifrDAO.getOwnerid();
		return idList;
	}

}
