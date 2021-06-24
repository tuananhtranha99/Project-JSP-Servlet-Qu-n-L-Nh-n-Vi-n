package com.tuananh.serviceimpl;

import javax.inject.Inject;

import com.tuananh.dao.IAccountDAO;
import com.tuananh.model.AccountModel;
import com.tuananh.service.IAccountService;

public class AccountService implements IAccountService{

	@Inject
	private IAccountDAO accountDAO;
	
	@Override
	public AccountModel findByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return accountDAO.findByUserNameAndPassword(username, password);
	}

}
