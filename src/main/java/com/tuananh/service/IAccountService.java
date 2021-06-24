package com.tuananh.service;

import com.tuananh.model.AccountModel;

public interface IAccountService {
	AccountModel findByUserNameAndPassword(String username, String password);
}
